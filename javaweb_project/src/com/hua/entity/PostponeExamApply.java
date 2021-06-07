package com.hua.entity;

//缓考申请信息类
public class PostponeExamApply {
	private String yearTerm;  //学年学期
	
	private String studentId;  //学号
	
	private String courseName;  //申请课程
	
	private String applyReason;  //申请原因

	public PostponeExamApply() {
		super();
	}

	public PostponeExamApply(String yearTerm, String studentId, String courseName,
			String applyReason) {
		super();
		this.yearTerm = yearTerm;
		this.studentId = studentId;
		this.courseName = courseName;
		this.applyReason = applyReason;
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

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getApplyReason() {
		return applyReason;
	}

	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}

	@Override
	public String toString() {
		return "PostponeExamApply [yearTerm=" + yearTerm +", studentId="
				+ studentId + ", courseName="+ courseName + ", applyReason=" 
				+ applyReason + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((applyReason == null) ? 0 : applyReason.hashCode());
		result = prime * result
				+ ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result
				+ ((studentId == null) ? 0 : studentId.hashCode());
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
		PostponeExamApply other = (PostponeExamApply) obj;
		if (applyReason == null) {
			if (other.applyReason != null)
				return false;
		} else if (!applyReason.equals(other.applyReason))
			return false;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		if (yearTerm == null) {
			if (other.yearTerm != null)
				return false;
		} else if (!yearTerm.equals(other.yearTerm))
			return false;
		return true;
	}
	
	
}
