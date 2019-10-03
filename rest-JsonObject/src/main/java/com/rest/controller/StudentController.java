package com.rest.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rest.error.handling.Exception.StudentNotFoundException;
import com.rest.student.Student;
@RestController
@RequestMapping("/list")
public class StudentController {
	private List<Student> theStudents;
	@PostConstruct
	public void init() {
		theStudents = new ArrayList<>();
		theStudents.add(new Student(1, "narendar", "z"));
		theStudents.add(new Student(2, "nandu", "a"));
		theStudents.add(new Student(3, "abhi", "x"));
	}
	@GetMapping("/students")
	
	public List<Student> studentList() {
		return theStudents;
	}
	@GetMapping("/student/{studentId}")
	public Student studentById(@PathVariable("studentId") int studentId) {
		if((studentId>=theStudents.size())||(studentId<0)){
			throw new StudentNotFoundException("student "+studentId+" id not found" );
		}
		return theStudents.get(studentId);
	}
	
	
	
}
