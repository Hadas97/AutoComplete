package com.example.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.repository.NamesRepository;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication
@ComponentScan(basePackages = AssignmentApplication.NAMES_PACKAGE)
//@EnableSwagger2
public class AssignmentApplication {
	
	public final static String NAMES_PACKAGE = "com.example";

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}
	
//	@Bean
//    public Docket api() { 
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.any())
//				.build();                                         
//    }
	

}
