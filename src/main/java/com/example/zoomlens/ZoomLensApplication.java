package com.example.zoomlens;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ZoomLensApplication {

    public static void main(String[] args) {
        ApplicationContext contexto = new SpringApplicationBuilder(ZoomLensApplication.class)
//                .web(WebApplicationType.NONE)
                .headless(false)
//                .bannerMode(Banner.Mode.OFF)
                .run(args);
//        SpringApplication.run(ZoomLensApplication.class, args);

    }

}
