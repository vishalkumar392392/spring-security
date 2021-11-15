package com.student.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.student.mapper.StudentMapper;
import com.student.modal.StudentModel;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private StudentMapper studentMapper;

	@Override
	public List<StudentModel> getAllStudents() {
		return studentRepository.findAll().stream().map(studentMapper::getModel).collect(Collectors.toList());
	}

	@Override
	public String save(StudentModel student) {
		return studentRepository.createStudent(student.getFirstName(), student.getLastName(), student.getEmail(),
				passwordEncoder.encode(student.getPassword()), student.getRole());
	}

	@Override
	public String deleteStudent(int id) {

		return studentRepository.deleteStudent(id);
	}

}
