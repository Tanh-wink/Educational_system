package com.hua.entity;

public class CriterStudent {
	
	private String academy;
	
	private String profession;
	
	private String className;
	
	private String studentName;
	
	private String studentId;

	public String getAcademy() {
		if(academy == null)
			academy = "%%";
		else
			academy = "%" + academy + "%";
		return academy;
	}

	public void setAcademy(String academy) {
		this.academy = academy;
	}

	public String getStudentName() {
		if(studentName == null)
			studentName = "%%";
		else
			studentName = "%" + studentName + "%";
		
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getProfession() {
		if(profession == null)
			profession = "%%";
		else
			profession = "%" + profession + "%";
		
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	

	public String getClassName() {
		if(className == null)
			className = "%%";
		else
			className = "%" + className + "%";
		
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getStudentId() {
		if(studentId == null)
			studentId = "%%";
		else
			studentId = "%" + studentId + "%";
			
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public CriterStudent() {
		super();
	}

	public CriterStudent(String academy, String profession, String className,
			String studentName, String studentId) {
		super();
		this.academy = academy;
		this.profession = profession;
		this.className = className;
		this.studentName = studentName;
		this.studentId = studentId;
	}
	
}
