package com.robosoft.SpringBootAOP_Employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class SpringBootAopEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAopEmployeeApplication.class, args);
	}

}
