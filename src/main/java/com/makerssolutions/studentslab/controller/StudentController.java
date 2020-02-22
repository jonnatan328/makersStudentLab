package com.makerssolutions.studentslab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.makerssolutions.studentslab.businessentity.Response;
import com.makerssolutions.studentslab.entity.Student;
import com.makerssolutions.studentslab.service.StudentService;

/**
 * Api de los estudiantes
 * @author jonnatan
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/getStudents")
	public Response<List<Student>> getAll() {
		return studentService.findAll();
	}
	
	@GetMapping("/students/{id}")
	public Response<Student> get(@PathVariable Long id) {
		return studentService.findById(id);
	}
	
	@PostMapping("/saveStudent")
	@ResponseStatus(HttpStatus.CREATED)
	public Response<Student> save(@RequestBody Student student) {
		return studentService.save(student);
	}
	
	@PutMapping("/updateStudent")
	public Response<Student> updateStudent(@RequestBody Student student) {
		return studentService.update(student);
	}
	
	@DeleteMapping("/student/remove/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Response<Student> removeStudent(@PathVariable Long id) {
		return studentService.remove(id);
	}
}
