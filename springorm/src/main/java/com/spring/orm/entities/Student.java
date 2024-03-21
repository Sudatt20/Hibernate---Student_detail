package com.spring.orm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_details")
public class Student {
	
   @Id
   @Column(name="student_id")
   private int studentId;
   @Column(name="student_name")	
   private String studentName;
   @Column(name="student_city")
   private String studentCity;
   
public Student(int studentId, String studentName, String studentCity) {
	super();
	this.studentId = studentId;
	this.studentName = studentName;
	this.studentCity = studentCity;
}

public Student() {
	super();
	// TODO Auto-generated constructor stub
}

/**
 * @return the studentId
 */
public int getStudentId() {
	return studentId;
}

/**
 * @param studentId the studentId to set
 */
public void setStudentId(int studentId) {
	this.studentId = studentId;
}

/**
 * @return the studentName
 */
public String getStudentName() {
	return studentName;
}

/**
 * @param studentName the studentName to set
 */
public void setStudentName(String studentName) {
	this.studentName = studentName;
}

/**
 * @return the studenntCity
 */
public String getStudentCity() {
	return studentCity;
}

/**
 * @param studenntCity the studenntCity to set
 */
public void setStudentCity(String studentCity) {
	this.studentCity = studentCity;
}
   

   
}
