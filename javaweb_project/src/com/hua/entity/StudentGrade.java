package com.hua.entity;

public class StudentGrade extends Student{

	private String yearTerm;  //学年学期
	
	private String courseId;  //课程编号

	private String courseName;  //课程名称

	private Integer score;   //分数

	private Double gradePoint;  //绩点
	
	private Double credit;   //学分

	private String courseClass;  //课程大类
	
	private String studyWay;  //修读方式：选修、必修
	
	private String examWay;  //考试性质：正常考试、补考、重修
	
	private String gradeWay;  //成绩方式：百分制、五级制
	
	private String effectivity;  //成绩有效
	
	private String remarks;  //备注

	public StudentGrade() {
		super();
	}

	public StudentGrade(String yearTerm, Long studentId, String studentName, 
			String courseId, String courseName,Integer score, Double gradePoint, 
			Double credit, String courseClass, String studyWay, String examWay,
			String gradeWay, String effectivity, String remarks) {
		super();
		this.yearTerm = yearTerm;
		this.studentId = studentId;
		this.studentName = studentName;
		this.courseId = courseId;
		this.courseName = courseName;
		this.score = score;
		this.gradePoint = gradePoint;
		this.credit = credit;
		this.courseClass = courseClass;
		this.studyWay = studyWay;
		this.examWay = examWay;
		this.gradeWay = gradeWay;
		this.effectivity = effectivity;
		this.remarks = remarks;
	}

	@Override
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
		
	}

	@Override
	public Long getStudentId() {
		return this.studentId;
	}

	@Override
	public void setStudentName(String studentName) {
		this.studentName = studentName;
		
	}

	@Override
	public String getStudentName() {
		return this.studentName;
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

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Double getGradePoint() {
		return gradePoint;
	}

	public void setGradePoint(Double gradePoint) {
		this.gradePoint = gradePoint;
	}

	public Double getCredit() {
		return credit;
	}

	public void setCredit(Double credit) {
		this.credit = credit;
	}

	public String getCourseClass() {
		return courseClass;
	}

	public void setCourseClass(String courseClass) {
		this.courseClass = courseClass;
	}

	public String getStudyWay() {
		return studyWay;
	}

	public void setStudyWay(String studyWay) {
		this.studyWay = studyWay;
	}

	public String getExamWay() {
		return examWay;
	}

	public void setExamWay(String examWay) {
		this.examWay = examWay;
	}

	public String getGradeWay() {
		return gradeWay;
	}

	public void setGradeWay(String gradeWay) {
		this.gradeWay = gradeWay;
	}

	public String getEffectivity() {
		return effectivity;
	}

	public void setEffectivity(String effectivity) {
		this.effectivity = effectivity;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "StudentGrade [yearTerm=" + yearTerm + ", courseId=" + courseId
				+ ", courseName=" + courseName + ", score=" + score
				+ ", gradePoint=" + gradePoint + ", credit=" + credit
				+ ", courseClass=" + courseClass + ", studyWay=" + studyWay
				+ ", examWay=" + examWay + ", gradeWay=" + gradeWay
				+ ", effectivity=" + effectivity + ", remarks=" + remarks
				+ ", studentid=" + studentId + ", studentName=" + studentName
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((studentId == null) ? 0 : studentId.hashCode());
		result = prime * result
				+ ((studentName == null) ? 0 : studentName.hashCode());
		result = prime * result
				+ ((courseClass == null) ? 0 : courseClass.hashCode());
		result = prime * result
				+ ((courseId == null) ? 0 : courseId.hashCode());
		result = prime * result
				+ ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result + ((credit == null) ? 0 : credit.hashCode());
		result = prime * result
				+ ((effectivity == null) ? 0 : effectivity.hashCode());
		result = prime * result + ((examWay == null) ? 0 : examWay.hashCode());
		result = prime * result
				+ ((gradePoint == null) ? 0 : gradePoint.hashCode());
		result = prime * result
				+ ((gradeWay == null) ? 0 : gradeWay.hashCode());
		result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
		result = prime * result + ((score == null) ? 0 : score.hashCode());
		result = prime * result
				+ ((studyWay == null) ? 0 : studyWay.hashCode());
		result = prime * result
				+ ((yearTerm == null) ? 0 : yearTerm.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentGrade other = (StudentGrade) obj;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		if (studentName == null) {
			if (other.studentName != null)
				return false;
		} else if (!studentName.equals(other.studentName))
			return false;	
		if (courseClass == null) {
			if (other.courseClass != null)
				return false;
		} else if (!courseClass.equals(other.courseClass))
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
		if (credit == null) {
			if (other.credit != null)
				return false;
		} else if (!credit.equals(other.credit))
			return false;
		if (effectivity == null) {
			if (other.effectivity != null)
				return false;
		} else if (!effectivity.equals(other.effectivity))
			return false;
		if (examWay == null) {
			if (other.examWay != null)
				return false;
		} else if (!examWay.equals(other.examWay))
			return false;
		if (gradePoint == null) {
			if (other.gradePoint != null)
				return false;
		} else if (!gradePoint.equals(other.gradePoint))
			return false;
		if (gradeWay == null) {
			if (other.gradeWay != null)
				return false;
		} else if (!gradeWay.equals(other.gradeWay))
			return false;
		if (remarks == null) {
			if (other.remarks != null)
				return false;
		} else if (!remarks.equals(other.remarks))
			return false;
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
		if (studyWay == null) {
			if (other.studyWay != null)
				return false;
		} else if (!studyWay.equals(other.studyWay))
			return false;
		if (yearTerm == null) {
			if (other.yearTerm != null)
				return false;
		} else if (!yearTerm.equals(other.yearTerm))
			return false;
		return true;
	}

	

	
	
	

}
