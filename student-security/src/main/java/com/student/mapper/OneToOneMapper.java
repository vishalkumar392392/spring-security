package com.student.mapper;

public interface OneToOneMapper<Model, Dto> {
	Dto getDTO(Model m);

	Model getModel(Dto d);
}
