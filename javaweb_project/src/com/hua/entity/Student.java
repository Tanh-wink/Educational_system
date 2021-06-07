package com.hua.entity;

public abstract class Student {
	public Long studentId;
	public String studentName;
	
	public abstract void setStudentId(Long studentId);
	
	public abstract Long getStudentId();
	
	public abstract void setStudentName(String studentName);
	
	public abstract String getStudentName();
}
