package com.robosoft.StudentMangement_mvc;

import com.robosoft.StudentMangement_mvc.entity.Student;
import com.robosoft.StudentMangement_mvc.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentMangementMvcApplication implements CommandLineRunner {

	public static void main(String[] args)
	{
		SpringApplication.run(StudentMangementMvcApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception
	{
//		Student std1 = new Student("Chandana","Ballaka","chandu@gmail.com");
//		studentRepository.save(std1);
//
//		Student std2 = new Student("Naman","Ballaka","naman@gmail.com");
//		studentRepository.save(std2);
//
//		Student std3 = new Student("Deppika","P Y","deepu@gmail.com");
//		studentRepository.save(std3);
	}
}
