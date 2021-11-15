package com.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.modal.StudentModel;

@Service
public interface StudentService {
	
	List<StudentModel> getAllStudents();

	String save(StudentModel student);

	String deleteStudent(int id);

}
