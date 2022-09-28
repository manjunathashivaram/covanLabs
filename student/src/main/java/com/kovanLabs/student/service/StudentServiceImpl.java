package com.kovanLabs.student.service;

import org.springframework.stereotype.Service;

import com.kovanLabs.student.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Override
	public Student saveStudent(Student student) {

		return student;
	}

	@Override
	public Student addStudent(Student student) {

		return student;
	}

}
