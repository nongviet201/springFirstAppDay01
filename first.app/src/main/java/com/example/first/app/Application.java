package com.example.first.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


// @Bean phai duoc dinh nghia trong class duoc chu thich boi @Configuration
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Bean
//	public Student student(){
//		return new Student(1, "A");
//	}
//
//	@Bean(name = "teacher1")
//	public Teacher teacher() {
//		return new Teacher(1, "Nguyen Van B");
//	}
//
//	@Bean(name = "teacher2")
//	public Teacher teacher2() {
//		return new Teacher(2, "Nguyen Van C");
//	}
}
