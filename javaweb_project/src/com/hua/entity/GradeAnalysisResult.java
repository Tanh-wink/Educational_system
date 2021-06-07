package com.hua.entity;

public class GradeAnalysisResult{
	
	private Long studentId;  //课程编号

	private Integer courseCount;  //课程门数

	private Integer score;   //总分

	private String gradePoint;  //绩点
	
	private String averCreditGrade;   //平均学分成绩

	private String averScore;  //平均分

	public GradeAnalysisResult() {
		super();
	}

	public GradeAnalysisResult(Long studentId, Integer courseCount,
			Integer score, String gradePoint, String averCreditGrade,
			String averScore) {
		super();
		this.studentId = studentId;
		this.courseCount = courseCount;
		this.score = score;
		this.gradePoint = gradePoint;
		this.averCreditGrade = averCreditGrade;
		this.averScore = averScore;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Integer getCourseCount() {
		return courseCount;
	}

	public void setCourseCount(Integer courseCount) {
		this.courseCount = courseCount;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getGradePoint() {
		return gradePoint;
	}

	public void setGradePoint(String gradePoint) {
		this.gradePoint = gradePoint;
	}

	public String getAverCreditGrade() {
		return averCreditGrade;
	}

	public void setAverCreditGrade(String averCreditGrade) {
		this.averCreditGrade = averCreditGrade;
	}

	public String getAverScore() {
		return averScore;
	}

	public void setAverScore(String averScore) {
		this.averScore = averScore;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((averCreditGrade == null) ? 0 : averCreditGrade.hashCode());
		result = prime * result
				+ ((averScore == null) ? 0 : averScore.hashCode());
		result = prime * result
				+ ((courseCount == null) ? 0 : courseCount.hashCode());
		result = prime * result
				+ ((gradePoint == null) ? 0 : gradePoint.hashCode());
		result = prime * result + ((score == null) ? 0 : score.hashCode());
		result = prime * result
				+ ((studentId == null) ? 0 : studentId.hashCode());
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
		GradeAnalysisResult other = (GradeAnalysisResult) obj;
		if (averCreditGrade == null) {
			if (other.averCreditGrade != null)
				return false;
		} else if (!averCreditGrade.equals(other.averCreditGrade))
			return false;
		if (averScore == null) {
			if (other.averScore != null)
				return false;
		} else if (!averScore.equals(other.averScore))
			return false;
		if (courseCount == null) {
			if (other.courseCount != null)
				return false;
		} else if (!courseCount.equals(other.courseCount))
			return false;
		if (gradePoint == null) {
			if (other.gradePoint != null)
				return false;
		} else if (!gradePoint.equals(other.gradePoint))
			return false;
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GradeAnalysisResult [studentId=" + studentId + ", courseCount="
				+ courseCount + ", score=" + score + ", gradePoint="
				+ gradePoint + ", averCreditGrade=" + averCreditGrade
				+ ", averScore=" + averScore + "]";
	}

	
}
