package com.hua.entity;

public class OptionalCourse {
	private String yearTerm;  //学年学期
	
	private String courseId;    //课程编号
	
	private String courseName;   //课程名称
	
	private String credit;   //学分
	
	private String courseType;   //课程类型
	
	private String teacher;  //上课老师
	
	private String classWay;   //上课方式
	
	private String classTime;   //上课时间

	public OptionalCourse() {
		super();
	}

	public OptionalCourse(String yearTerm, String courseId, String courseName,
			String credit, String courseType, String teacher, String classWay,
			String classTime) {
		super();
		this.yearTerm = yearTerm;
		this.courseId = courseId;
		this.courseName = courseName;
		this.credit = credit;
		this.courseType = courseType;
		this.teacher = teacher;
		this.classWay = classWay;
		this.classTime = classTime;
	}

	public String getYearTerm() {
		return yearTerm;
	}

	public void setYearTerm(String yearTerm) {
		this.yearTerm = yearTerm;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getClassWay() {
		return classWay;
	}

	public void setClassWay(String classWay) {
		this.classWay = classWay;
	}

	public String getClassTime() {
		return classTime;
	}

	public void setClassTime(String classTime) {
		this.classTime = classTime;
	}

	@Override
	public String toString() {
		return "OptionalCourse [yearTerm=" + yearTerm + ", courseId="
				+ courseId + ", courseName=" + courseName + ", credit="
				+ credit + ", courseType=" + courseType + ", teacher="
				+ teacher + ", classWay=" + classWay + ", classTime="
				+ classTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((classTime == null) ? 0 : classTime.hashCode());
		result = prime * result
				+ ((classWay == null) ? 0 : classWay.hashCode());
		result = prime * result
				+ ((courseId == null) ? 0 : courseId.hashCode());
		result = prime * result
				+ ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result
				+ ((courseType == null) ? 0 : courseType.hashCode());
		result = prime * result + ((credit == null) ? 0 : credit.hashCode());
		result = prime * result + ((teacher == null) ? 0 : teacher.hashCode());
		result = prime * result
				+ ((yearTerm == null) ? 0 : yearTerm.hashCode());
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
		OptionalCourse other = (OptionalCourse) obj;
		if (classTime == null) {
			if (other.classTime != null)
				return false;
		} else if (!classTime.equals(other.classTime))
			return false;
		if (classWay == null) {
			if (other.classWay != null)
				return false;
		} else if (!classWay.equals(other.classWay))
			return false;
		if (courseId == null) {
			if (other.courseId != null)
				return false;
		} else if (!courseId.equals(other.courseId))
			return false;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		if (courseType == null) {
			if (other.courseType != null)
				return false;
		} else if (!courseType.equals(other.courseType))
			return false;
		if (credit == null) {
			if (other.credit != null)
				return false;
		} else if (!credit.equals(other.credit))
			return false;
		if (teacher == null) {
			if (other.teacher != null)
				return false;
		} else if (!teacher.equals(other.teacher))
			return false;
		if (yearTerm == null) {
			if (other.yearTerm != null)
				return false;
		} else if (!yearTerm.equals(other.yearTerm))
			return false;
		return true;
	}
	
}
