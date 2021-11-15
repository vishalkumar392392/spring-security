package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student findByEmail(String username);

	@Query(value = "{call register_student(:firstName,:lastName,:email,:password,:role) }", nativeQuery = true)
	String createStudent(@Param("firstName") String firstName, @Param("lastName") String lastName,
			@Param("email") String email, @Param("password") String password, @Param("role") int role);

	@Query(value = "{call delete_student(:id)}", nativeQuery = true)
	String deleteStudent(@Param("id") int id);

}
