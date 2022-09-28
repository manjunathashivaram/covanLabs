package com.kovanLabs.student.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Entity
//@Table(name="student_table)
public class Student {
	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	// @Column(length=25)
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
}
