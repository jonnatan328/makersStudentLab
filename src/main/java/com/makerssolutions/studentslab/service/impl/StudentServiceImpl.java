package com.makerssolutions.studentslab.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makerssolutions.studentslab.businessentity.Response;
import com.makerssolutions.studentslab.entity.Student;
import com.makerssolutions.studentslab.repository.StudentRepository;
import com.makerssolutions.studentslab.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	private final static String DESHABILITADO = "DESHABILITADO";
	
	@Autowired
	private StudentRepository studentRepository;
	
	/**
	 * Servicio que permite obtener un estudiante por id
	 */
	@Override
	public Response<Student> findById(Long id) {
		Optional<Student> optionalStudent= studentRepository.findById(id);
		Student student = optionalStudent.get();
		Response<Student> response = new Response<Student>();
		response.setBody(student);
		return response;
	}
	
	/**
	 * Metodo que nos permite guardar un estudiante.
	 */
	@Override
	public Response<Student> save(Student student) {
		Student studentSaved = studentRepository.save(student);
		Response<Student> response = new Response<Student>();
		response.setBody(studentSaved);
		return response;
	}
	
	/**
	 * Metodo que permite actualizar un estudiante
	 */
	@Override
	public Response<Student> update(Student student) {
		Optional<Student> optionalStudent= studentRepository.findById(student.getId());
		
		Student studentToUpdate = optionalStudent.get();
		studentToUpdate.setFirstname(student.getFirstname());
		studentToUpdate.setLastname(student.getLastname());
		studentToUpdate.setEmail(student.getEmail());
		
		Student studentUpdated = studentRepository.save(studentToUpdate);
		Response<Student> response = new Response<Student>();
		response.setBody(studentUpdated);
		return response;
	}
	
	/**
	 * Metodo que permite obtener todos los estudiantes
	 */
	@Override
	public Response<List<Student>> findAll() {
		Response<List<Student>> response = new Response<List<Student>>();
		List<Student> students = studentRepository.findAll();
		List<Student> studentsAvailables = students.stream().filter(student -> student.getState() != DESHABILITADO).collect(Collectors.toList());
		response.setBody(studentsAvailables);
		return response;
	}
	
	/**
	 * Metodo que permite eliminar un estudiante.
	 */
	@Override
	public Response<Student> remove(Long id) {
		Optional<Student> optionalStudent= studentRepository.findById(id);
		
		Student studentToRemove = optionalStudent.get();
		studentToRemove.setState(DESHABILITADO);
		
		Student studentRemoved = studentRepository.save(studentToRemove);
		Response<Student> response = new Response<Student>();
		response.setBody(studentRemoved);
		return response;
	}

}
