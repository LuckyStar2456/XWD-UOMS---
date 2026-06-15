# XWD-UOMS - 设备组织管理系统

> XWD-UOMS (Equipment Organization Management System) 是一个基于 Spring Boot + React 构建的设备组织管理系统，提供设备管理、组织管理、借用申请、任务分配等核心功能。

## 🏗️ 技术架构

### 后端技术栈
| 技术 | 版本 | 说明 |
|------|------|------|
| Java | 25 | 编程语言 |
| Spring Boot | 4.0.2 | 后端框架 |
| Spring Security | - | 安全框架 |
| Spring Data JPA | - | ORM框架 |
| MySQL | 8.0+ | 关系型数据库 |
| Redis | 7.0+ | 缓存数据库 |
| JWT | 0.11.5 | 身份认证 |
| Hutool | 5.8.40 | 工具库 |

### 前端技术栈
| 技术 | 版本 | 说明 |
|------|------|------|
| React | 19.2.4 | 前端框架 |
| Vite | 8.0.1 | 构建工具 |
| Ant Design | 6.3.4 | UI组件库 |
| Redux Toolkit | 2.11.2 | 状态管理 |
| React Router | 7.13.2 | 路由管理 |
| Axios | 1.14.0 | HTTP客户端 |

## 📁 项目结构

```
XWD_UOMS/
├── xwd-uoms-web/          # 后端服务
│   ├── src/main/java/com/xwd/xwd_uoms/
│   │   ├── controller/     # REST API 控制器
│   │   ├── service/        # 业务逻辑层
│   │   ├── repository/     # 数据访问层
│   │   ├── entity/         # 实体类
│   │   ├── config/         # 配置类
│   │   ├── common/         # 通用组件
│   │   │   ├── util/       # 工具类
│   │   │   ├── filter/     # 过滤器
│   │   │   ├── aspect/     # AOP切面
│   │   │   ├── exception/  # 异常处理
│   │   │   └── annotation/ # 自定义注解
│   │   └── XwdUomsApplication.java
│   └── src/main/resources/
│       └── application.properties
├── xwd-uoms-frontend/      # 前端应用
│   ├── src/
│   │   ├── pages/          # 页面组件
│   │   ├── components/     # 公共组件
│   │   ├── layouts/        # 布局组件
│   │   ├── api/            # API接口
│   │   ├── store/          # Redux状态管理
│   │   ├── router/         # 路由配置
│   │   └── utils/          # 工具函数
│   ├── index.html
│   ├── package.json
│   └── vite.config.js
└── README.md
```

## ✨ 核心功能

### 系统模块

| 模块 | 功能描述 |
|------|----------|
| 🏠 **首页** | 系统概览、数据统计 |
| 🔐 **登录认证** | 用户登录、Token刷新 |
| 📦 **设备管理** | 设备信息管理、状态维护 |
| 🏢 **组织管理** | 组织架构管理 |
| 👥 **部门管理** | 部门信息管理 |
| 📝 **借用记录** | 设备借用历史查询 |
| 📋 **申请管理** | 借用申请流程 |
| ✅ **任务管理** | 任务分配与跟踪 |
| 💬 **反馈管理** | 用户反馈处理 |
| 📢 **通知管理** | 系统通知发布 |
| 👤 **个人中心** | 用户信息管理 |

### 权限控制

- **JWT Token 认证**：无状态身份验证
- **角色权限系统**：细粒度权限控制
- **接口权限注解**：`@RequirePermission` 注解

## 🚀 快速开始

### 环境要求

- JDK 25+
- Maven 3.8+
- Node.js 20+
- MySQL 8.0+
- Redis 7.0+

### 后端启动

1. **配置数据库**

   修改 `xwd-uoms-web/src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/xwd_uoms_data
   spring.datasource.username=${DB_USERNAME:root}
   spring.datasource.password=${DB_PASSWORD:your_password}
   spring.data.redis.host=localhost
   spring.data.redis.port=6379
   sys.jwt.secret=${JWT_SECRET:your-secret-key-at-least-32-chars}
   ```

2. **启动服务**
   ```bash
   cd xwd-uoms-web
   mvn spring-boot:run
   ```

### 前端启动

1. **安装依赖**
   ```bash
   cd xwd-uoms-frontend
   npm install
   ```

2. **启动开发服务器**
   ```bash
   npm run dev
   ```

### 访问地址

- 前端：http://localhost:5173
- 后端：http://localhost:8080

## 🔧 API 接口

### 认证接口

| 方法 | 路径 | 描述 |
|------|------|------|
| POST | `/xwd_uoms/api/auth/login` | 用户登录 |
| POST | `/xwd_uoms/api/auth/refresh` | 刷新Token |

### 设备管理

| 方法 | 路径 | 描述 |
|------|------|------|
| GET | `/xwd_uoms/api/equip` | 获取设备列表 |
| POST | `/xwd_uoms/api/equip` | 创建设备 |
| GET | `/xwd_uoms/api/equip/{id}` | 获取设备详情 |
| PUT | `/xwd_uoms/api/equip/{id}` | 更新设备 |
| DELETE | `/xwd_uoms/api/equip/{id}` | 删除设备 |

### 申请管理

| 方法 | 路径 | 描述 |
|------|------|------|
| GET | `/xwd_uoms/api/apply` | 获取申请列表 |
| POST | `/xwd_uoms/api/apply` | 提交申请 |
| PUT | `/xwd_uoms/api/apply/{id}/approve` | 审批申请 |

### 任务管理

| 方法 | 路径 | 描述 |
|------|------|------|
| GET | `/xwd_uoms/api/task` | 获取任务列表 |
| POST | `/xwd_uoms/api/task` | 创建任务 |
| PUT | `/xwd_uoms/api/task/{id}` | 更新任务状态 |

## 📊 数据库设计

### 核心数据表

| 表名 | 说明 |
|------|------|
| `sys_user` | 用户信息表 |
| `sys_role` | 角色表 |
| `sys_organization` | 组织表 |
| `sys_department` | 部门表 |
| `sys_equipment` | 设备表 |
| `sys_equipment_borrow` | 设备借用表 |
| `sys_apply` | 申请表 |
| `sys_task` | 任务表 |
| `sys_feedback` | 反馈表 |
| `sys_notice` | 通知表 |

## 🛡️ 安全特性

- ✅ JWT Token 认证
- ✅ 密码加密存储 (BCrypt)
- ✅ 请求参数校验
- ✅ 全局异常处理
- ✅ SQL注入防护
- ✅ XSS攻击防护

## 📝 开发规范

### 代码风格

- Java：遵循 Spring 官方编码规范
- JavaScript/React：遵循 ESLint 规范

### 提交规范

```
feat: 添加新功能
fix: 修复bug
docs: 更新文档
style: 代码格式调整
refactor: 重构代码
test: 添加测试
chore: 构建/工具相关
```

## 📄 许可证

MIT License - 详见 [LICENSE](LICENSE)

## 🤝 贡献

欢迎提交 Issue 和 Pull Request！

---

**XWD-UOMS** - 高效、安全的设备组织管理系统