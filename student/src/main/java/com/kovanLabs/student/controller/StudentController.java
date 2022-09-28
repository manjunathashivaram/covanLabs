package com.kovanLabs.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kovanLabs.student.controller.aspect.LogRequest;
import com.kovanLabs.student.entity.Student;
import com.kovanLabs.student.service.StudentServiceImpl;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentServiceImpl serviceImpl;

	@LogRequest(onOffRequest = true)
	@PostMapping("/save")
	public ResponseEntity<String> saveStudent(@RequestBody Student student) {
		log.info("message from save() in Controller");
		serviceImpl.saveStudent(student);
		return ResponseEntity.status(HttpStatus.OK).body("Http request for saveStudent is ok");
	}

	@LogRequest(onOffRequest = false)
	@PostMapping("/saveStudent")
	public ResponseEntity<String> addStudent(@RequestBody Student student) {
		log.info("addStudent() in controller");
		serviceImpl.addStudent(student);
		return ResponseEntity.status(HttpStatus.OK).body("Http request for addStudent() is ok");
	}
}
