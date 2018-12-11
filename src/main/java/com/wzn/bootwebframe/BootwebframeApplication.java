package com.wzn.bootwebframe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:dubbo.xml"})
//@EnableAutoConfiguration(exclude = {WebMvcAutoConfiguration.class,ErrorMvcAutoConfiguration.class})
public class BootwebframeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootwebframeApplication.class, args);
	}
}
