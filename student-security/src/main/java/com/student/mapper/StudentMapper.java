package com.student.mapper;

import org.mapstruct.Mapper;

import com.student.entity.Student;
import com.student.modal.StudentModel;

@Mapper(componentModel = "spring")
public interface StudentMapper extends OneToOneMapper<StudentModel, Student>{

}
