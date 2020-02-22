package com.makerssolutions.studentslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.makerssolutions.studentslab.entity.Student;


public interface StudentRepository extends JpaRepository<Student, Long>{
	
}
