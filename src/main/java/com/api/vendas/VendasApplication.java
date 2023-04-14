package com.api.vendas;

import com.api.vendas.dao.StudentDAO;
import com.api.vendas.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			deleteStudent(studentDAO);
		};
	}

	private void deleteStudent(StudentDAO studentDAO) {
		Integer studentId = 5;
		studentDAO.deleteStudent(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 2;
		Student theStudent = studentDAO.findById(studentId);
		theStudent.setFirstName("Scooby");
		studentDAO.update(theStudent);
		System.out.println("Updated student: " + theStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> list = studentDAO.findByLastName("Frias");
		for(Student item : list){
			System.out.println(item);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();
		for(Student itens : theStudents){
			System.out.println(itens);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println(studentDAO.findById(2));
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
		Student tempStudent = new Student("Joana", "Frias", "Joana@gmail.com");

		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

}
