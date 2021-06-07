package com.hua.entity;

public class ExamArrange {
	
	private String yearTerm;  //学年学期
	
	private String studentId;  //学号
	
	private String studentName;  //学生姓名
	
	private String examCourse;  //考试课程
	
	private String examWay;  //考试形式
	
	private String examDate;  //考级日期
	
	private String examTime;  //考级时间
	
	private String examWeek;  //考试周次

	private String examCampus;  //考试校区
	
	private String examplace;  //考试地点
	
	private String examSeatNum;  //考试座位号

	public ExamArrange() {
		super();
	}

	public ExamArrange(String yearTerm, String studentId, String studentName,
			String examCourse, String examWay, String examDate,
			String examTime, String examWeek, String examCampus,
			String examplace, String examSeatNum) {
		super();
		this.yearTerm = yearTerm;
		this.studentId = studentId;
		this.studentName = studentName;
		this.examCourse = examCourse;
		this.examWay = examWay;
		this.examDate = examDate;
		this.examTime = examTime;
		this.examWeek = examWeek;
		this.examCampus = examCampus;
		this.examplace = examplace;
		this.examSeatNum = examSeatNum;
	}

	public String getYearTerm() {
		return yearTerm;
	}

	public void setYearTerm(String yearTerm) {
		this.yearTerm = yearTerm;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getExamCourse() {
		return examCourse;
	}

	public void setExamCourse(String examCourse) {
		this.examCourse = examCourse;
	}

	public String getExamWay() {
		return examWay;
	}

	public void setExamWay(String examWay) {
		this.examWay = examWay;
	}

	public String getExamDate() {
		return examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}

	public String getExamTime() {
		return examTime;
	}

	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}

	public String getExamWeek() {
		return examWeek;
	}

	public void setExamWeek(String examWeek) {
		this.examWeek = examWeek;
	}

	public String getExamCampus() {
		return examCampus;
	}

	public void setExamCampus(String examCampus) {
		this.examCampus = examCampus;
	}

	public String getExamplace() {
		return examplace;
	}

	public void setExamplace(String examplace) {
		this.examplace = examplace;
	}

	public String getExamSeatNum() {
		return examSeatNum;
	}

	public void setExamSeatNum(String examSeatNum) {
		this.examSeatNum = examSeatNum;
	}

	@Override
	public String toString() {
		return "ExamArrange [yearTerm=" + yearTerm + ", studentId=" + studentId
				+ ", studentName=" + studentName + ", examCourse=" + examCourse
				+ ", examWay=" + examWay + ", examDate=" + examDate
				+ ", examTime=" + examTime + ", examWeek=" + examWeek
				+ ", examCampus=" + examCampus + ", examplace=" + examplace
				+ ", examSeatNum=" + examSeatNum + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((examCampus == null) ? 0 : examCampus.hashCode());
		result = prime * result
				+ ((examCourse == null) ? 0 : examCourse.hashCode());
		result = prime * result
				+ ((examDate == null) ? 0 : examDate.hashCode());
		result = prime * result
				+ ((examSeatNum == null) ? 0 : examSeatNum.hashCode());
		result = prime * result
				+ ((examTime == null) ? 0 : examTime.hashCode());
		result = prime * result + ((examWay == null) ? 0 : examWay.hashCode());
		result = prime * result
				+ ((examWeek == null) ? 0 : examWeek.hashCode());
		result = prime * result
				+ ((examplace == null) ? 0 : examplace.hashCode());
		result = prime * result
				+ ((studentId == null) ? 0 : studentId.hashCode());
		result = prime * result
				+ ((studentName == null) ? 0 : studentName.hashCode());
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
		ExamArrange other = (ExamArrange) obj;
		if (examCampus == null) {
			if (other.examCampus != null)
				return false;
		} else if (!examCampus.equals(other.examCampus))
			return false;
		if (examCourse == null) {
			if (other.examCourse != null)
				return false;
		} else if (!examCourse.equals(other.examCourse))
			return false;
		if (examDate == null) {
			if (other.examDate != null)
				return false;
		} else if (!examDate.equals(other.examDate))
			return false;
		if (examSeatNum == null) {
			if (other.examSeatNum != null)
				return false;
		} else if (!examSeatNum.equals(other.examSeatNum))
			return false;
		if (examTime == null) {
			if (other.examTime != null)
				return false;
		} else if (!examTime.equals(other.examTime))
			return false;
		if (examWay == null) {
			if (other.examWay != null)
				return false;
		} else if (!examWay.equals(other.examWay))
			return false;
		if (examWeek == null) {
			if (other.examWeek != null)
				return false;
		} else if (!examWeek.equals(other.examWeek))
			return false;
		if (examplace == null) {
			if (other.examplace != null)
				return false;
		} else if (!examplace.equals(other.examplace))
			return false;
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
		if (yearTerm == null) {
			if (other.yearTerm != null)
				return false;
		} else if (!yearTerm.equals(other.yearTerm))
			return false;
		return true;
	}

	
	
}
