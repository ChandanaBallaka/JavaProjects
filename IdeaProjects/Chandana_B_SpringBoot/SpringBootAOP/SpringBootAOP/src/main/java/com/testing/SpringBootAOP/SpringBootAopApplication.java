package com.testing.SpringBootAOP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

@SpringBootApplication
public class SpringBootAopApplication
{

	public static void main(String[] args) {
		//SpringApplication.run(SpringBootAopApplication.class, args);

		AbstractApplicationContext  con = new AnnotationConfigApplicationContext(AppConfig.class);
		Student st = con.getBean("student",Student.class);
		//new Human().wakeUp();
		st.study();
		Student st1 = con.getBean("student",Student.class);
		st1.studySomething();

		Employee emp = con.getBean("employee",Employee.class);
		//jointpoint
		emp.study();
		Employee emp1 = con.getBean("employee",Employee.class);
		//jointpoint
		emp1.studyAnything();
		Employee emp2 = con.getBean("employee",Employee.class);
		emp1.studyAnySubject(5,5);
	}

}
