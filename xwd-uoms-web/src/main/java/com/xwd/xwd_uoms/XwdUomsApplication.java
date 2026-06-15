package com.xwd.xwd_uoms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;

@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
public class XwdUomsApplication {
    public static void main(String[] args) {
        SpringApplication.run(XwdUomsApplication.class, args);
        System.out.println("\n" +
                "────────────────────────────────────────────────────────────────────────────────\n" +
                "๑˃̵ᴗ˂̵๑                          ๑˃̵ᴗ˂̵๑                          ๑˃̵ᴗ˂̵๑\n" +
                "────────────────────────────────────────────────────────────────────────────────\n" +
                "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n" +
                "┃                                                                     _          ┃\n" +
                "┃                ┏━━┓┏━━┓┏━━┓┏━━┓┏━━┓┏━━┓┏━━┓┏━━┓  ┏━━┓┏━━┓┏━━┓┏━━┓  |||         ┃\n" +
                "┃                ┃X ┃┃W ┃┃D ┃┃_ ┃┃U ┃┃O ┃┃M ┃┃S ┃  ┃P ┃┃L ┃┃A ┃┃Y ┃  |||         ┃\n" +
                "┃                ┗━━┛┗━━┛┗━━┛┗━━┛┗━━┛┗━━┛┗━━┛┗━━┛  ┗━━┛┗━━┛┗━━┛┗━━┛   ~          ┃\n" +
                "┃                                                                     ⁕          ┃\n" +
                "┃        (◍•ᴗ•◍)❤                (◍•ᴗ•◍)❤                (◍•ᴗ•◍)❤           ┃\n" +
                "┃                                                                                ┃\n" +
                "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n" +
                "────────────────────────────────────────────────────────────────────────────────\n" +
                "          ʕ˙Ⱉ˙ʔ                      ʕ˙Ⱉ˙ʔ                      ʕ˙Ⱉ˙ʔ\n" +
                "────────────────────────────────────────────────────────────────────────────────\n" +
                "          ʕ•ᴥ•ʔ                      ʕ•ᴥ•ʔ                      ʕ•ᴥ•ʔ\n" +
                "────────────────────────────────────────────────────────────────────────────────\n" +
                "          ʕ˃̵ᴥ˂̵ʔ                     ʕ˃̵ᴥ˂̵ʔ                     ʕ˃̵ᴥ˂̵ʔ\n" +
                "────────────────────────────────────────────────────────────────────────────────");
    }

}
