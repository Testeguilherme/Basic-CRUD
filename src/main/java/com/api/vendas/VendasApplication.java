package com.api.vendas;

import com.api.vendas.dao.StudentDAO;
import com.api.vendas.dao.StudentDAOImpl;
import com.api.vendas.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VendasApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		System.out.println("Creating multiple students object ...");
		Student tempStudent1 = new Student("Shaolin", "Matador de Porco", "shaolas@outlook.com");
		Student tempStudent2 = new Student("Ronaldinho", "Gaucho", "ronaldin@gmail.com");
		Student tempStudent3 = new Student("Flavin", "do Pneu", "flavin@doPneu.com");

		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Guilherme", "Frias", "Gui@hotmail.com");

		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated id: " + tempStudent.getId());


	}

}
