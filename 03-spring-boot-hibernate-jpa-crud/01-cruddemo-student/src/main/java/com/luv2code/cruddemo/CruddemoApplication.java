package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return args -> {
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudent(studentDAO);

			//queryForStudentByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			// deleteAllStudents(studentDAO);

		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {

		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted Row count: " + numRowsDeleted);

	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 3;
		System.out.println("Deleting the student with id: " + studentId);

		studentDAO.delete(studentId);

	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findByID(studentId);

		// change first name to "Scooby"
		System.out.println("Updating the student... ");
		myStudent.setFirstName("Scooby");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated Student: " + myStudent);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		// get list of students
		List<Student> theStudents = studentDAO.findbyLastName("Scott");

		// display list of students
		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {
		// get list of students
		List<Student> theStudents = studentDAO.findAll();

		//display list of students
		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// Create student object
		System.out.println("Create Student object... ");
		Student tempStudent = new Student("Tim", "Scott", "Tim@luve2code.com");

		// save student
		System.out.println("Saving the student... ");
		studentDAO.save(tempStudent);

		// display id of saved student
		int theID = tempStudent.getId();

		System.out.println("Saved student. Generated id: " + theID);

		// retrieve student based on id: primary key
		System.out.println("Retrieving student with id: " + theID);
		Student myStudent = studentDAO.findByID(theID);

		// display student
		System.out.println("Displaying the student: " + myStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create multiple students
		System.out.println("Creating 3 student objects... ");
		Student tempStudent1 = new Student("John", "Doe", "John@luve2code.com");
		Student tempStudent2 = new Student("Mary", "Public", "Mary@luve2code.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "Bonita@luve2code.com");

		// save the student obejcts
		System.out.println("Saving the student... ");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object... ");
		Student tempStudent = new Student("Paul", "Doe", "paul@luve2code.com");

		// save the student object
		System.out.println("Saving the student... ");
		studentDAO.save(tempStudent);

		// display id of saved object
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}
