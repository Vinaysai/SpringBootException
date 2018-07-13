package com.sprinf.boot.all.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprinf.boot.all.bean.StudentBean;
import com.sprinf.boot.all.entity.Student;
import com.sprinf.boot.all.exception.StudentNotFoundException;
import com.sprinf.boot.all.repository.StudentRepository;
import com.sprinf.boot.all.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	public StudentService service;

	@Autowired
	public StudentRepository studentRepository;

	@PutMapping(value = "/api/create", consumes = "application/json", produces = "application/json")
	public Student insertStudent(@RequestBody StudentBean bean) {

		Student insert = service.insert(bean);
		return insert;
	}

	@PutMapping(value = "/api/client/update/{id}")
	public Student update(@PathVariable("id") String id, @RequestBody StudentBean s) {

		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("STUD_ID", "Student not found"));
		

		student.setFname(s.getFname());
		student.setLname(s.getLname());

		Student st = studentRepository.save(student);

		return st;
	}

	@DeleteMapping(value = "/api/client/delete/{id}")
	public String delete(@PathVariable("id") String id) {
		

		String delete = service.delete(id);
		if (delete == null)
			return "fail";
		else
			return "success";

	}
	@GetMapping(value = "/api/client/retriveallclients", produces = "application/json")
	public List<Student> findAll() {

		List<Student> viewList = service.findAll();
		return viewList;
	}

	// Get a Particular Record

	@GetMapping(value = "/api/client/retriveallclients/{id}", produces = "application/json")
	public Optional findStudent(@PathVariable("id") String id) {

		Optional findStudent = service.findStudent(id);

		return findStudent;

	}

}