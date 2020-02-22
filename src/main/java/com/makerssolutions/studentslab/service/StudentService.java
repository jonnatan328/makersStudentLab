package com.makerssolutions.studentslab.service;

import java.util.List;

import com.makerssolutions.studentslab.businessentity.Response;
import com.makerssolutions.studentslab.entity.Student;

public interface StudentService {
	
	public Response<Student> findById(Long id);
	
	public Response<List<Student>> findAll();
	
	public Response<Student> save(Student student);

	public Response<Student> update(Student student);
	
	public Response<Student> remove(Long id);
}
