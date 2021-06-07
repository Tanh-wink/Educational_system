package com.hua.entity;

public class CourseSchedule {
	private String studentId;  //学号
	
	private String week;    //第几周
	
	private String weekday;   //星期几
	
	private String joint;   //第几节
	
	private String course;   //课程
	
	private String teacher;  //上课老师
	
	private String classplace;   //上课地点

	public CourseSchedule() {
		super();
	}

	public CourseSchedule(String studentId, String week, String weekday,
			String joint, String course, String teacher, String classplace) {
		super();
		this.studentId = studentId;
		this.week = week;
		this.weekday = weekday;
		this.joint = joint;
		this.course = course;
		this.teacher = teacher;
		this.classplace = classplace;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getWeekday() {
		return weekday;
	}

	public void setWeekday(String weekday) {
		this.weekday = weekday;
	}

	public String getJoint() {
		return joint;
	}

	public void setJoint(String joint) {
		this.joint = joint;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getClassplace() {
		return classplace;
	}

	public void setClassplace(String classplace) {
		this.classplace = classplace;
	}

	@Override
	public String toString() {
		return "CourseSchedule [studentId=" + studentId + ", week=" + week
				+ ", weekday=" + weekday + ", joint=" + joint + ", course="
				+ course + ", teacher=" + teacher + ", classplace="
				+ classplace + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((classplace == null) ? 0 : classplace.hashCode());
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + ((joint == null) ? 0 : joint.hashCode());
		result = prime * result
				+ ((studentId == null) ? 0 : studentId.hashCode());
		result = prime * result + ((teacher == null) ? 0 : teacher.hashCode());
		result = prime * result + ((week == null) ? 0 : week.hashCode());
		result = prime * result + ((weekday == null) ? 0 : weekday.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseSchedule other = (CourseSchedule) obj;
		if (classplace == null) {
			if (other.classplace != null)
				return false;
		} else if (!classplace.equals(other.classplace))
			return false;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (joint == null) {
			if (other.joint != null)
				return false;
		} else if (!joint.equals(other.joint))
			return false;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		if (teacher == null) {
			if (other.teacher != null)
				return false;
		} else if (!teacher.equals(other.teacher))
			return false;
		if (week == null) {
			if (other.week != null)
				return false;
		} else if (!week.equals(other.week))
			return false;
		if (weekday == null) {
			if (other.weekday != null)
				return false;
		} else if (!weekday.equals(other.weekday))
			return false;
		return true;
	}
	
	
}
