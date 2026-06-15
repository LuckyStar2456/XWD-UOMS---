package com.xwd.xwd_uoms.common.filter;

import com.xwd.xwd_uoms.common.util.JwtUtil;
import com.xwd.xwd_uoms.common.util.TokenExtractUtil;
import com.xwd.xwd_uoms.entity.SysUserEntity;
import com.xwd.xwd_uoms.repository.SysUserRepository;
import io.jsonwebtoken.Claims;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Resource
    private TokenExtractUtil tokenExtractUtil;
    @Resource
    private JwtUtil jwtUtil;
    @Resource
    private SysUserRepository sysUserRepository;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        try {
            String jwt = tokenExtractUtil.extractJwt();

            if (jwt != null && !jwt.isEmpty() && SecurityContextHolder.getContext().getAuthentication() == null) {
                jwtUtil.validateToken(jwt);

                Claims claims = jwtUtil.parseToken(jwt);
                String username = claims.get("username", String.class);

                SysUserEntity sysUser = sysUserRepository.findSysUserEntityByUsername(username);
                if (sysUser == null) {
                    throw new IllegalArgumentException("Token中的用户不存在.");
                }

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        username,
                        null,
                        Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + sysUser.getRoleId()))
                );
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            logger.error("JWT拦截验证失败: " + e.getMessage());
        }

        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();
        return path.startsWith("/xwd_uoms/api/auth/");
    }
}