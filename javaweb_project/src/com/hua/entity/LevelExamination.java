package com.hua.entity;

public class LevelExamination {
	

	private String yearTerm;  //学年学期
	
	private String studentId;  //学号
	
	private String levelEaxmCourse;  //考级课程
	
	private String eaxmTime;  //考级时间
	
	private String grade;  //总成绩
	
	private String examId;  //准考证号
	
	private String listenGrade;  //听力成绩
	
	private String readingGrade;  //阅读成绩
	
	private String writingGrade;  //写作成绩
	
	private String spokenGrade;  //口语成绩

	public LevelExamination(String yearTerm, String studentId,
			String levelEaxmCourse, String eaxmTime, String grade,
			String examId, String listenGrade, String readingGrade,
			String writingGrade, String spokenGrade) {
		super();
		this.yearTerm = yearTerm;
		this.studentId = studentId;
		this.levelEaxmCourse = levelEaxmCourse;
		this.eaxmTime = eaxmTime;
		this.grade = grade;
		this.examId = examId;
		this.listenGrade = listenGrade;
		this.readingGrade = readingGrade;
		this.writingGrade = writingGrade;
		this.spokenGrade = spokenGrade;
	}

	public LevelExamination() {
		super();
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

	public String getLevelEaxmCourse() {
		return levelEaxmCourse;
	}

	public void setLevelEaxmCourse(String levelEaxmCourse) {
		this.levelEaxmCourse = levelEaxmCourse;
	}

	public String getEaxmTime() {
		return eaxmTime;
	}

	public void setEaxmTime(String eaxmTime) {
		this.eaxmTime = eaxmTime;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getExamId() {
		return examId;
	}

	public void setExamId(String examId) {
		this.examId = examId;
	}

	public String getListenGrade() {
		return listenGrade;
	}

	public void setListenGrade(String listenGrade) {
		this.listenGrade = listenGrade;
	}

	public String getReadingGrade() {
		return readingGrade;
	}

	public void setReadingGrade(String readingGrade) {
		this.readingGrade = readingGrade;
	}

	public String getWritingGrade() {
		return writingGrade;
	}

	public void setWritingGrade(String writingGrade) {
		this.writingGrade = writingGrade;
	}

	public String getSpokenGrade() {
		return spokenGrade;
	}

	public void setSpokenGrade(String spokenGrade) {
		this.spokenGrade = spokenGrade;
	}

	@Override
	public String toString() {
		return "LevalExamination [yearTerm=" + yearTerm + ", studentId="
				+ studentId + ", levelEaxmCourse=" + levelEaxmCourse
				+ ", eaxmTime=" + eaxmTime + ", grade=" + grade + ", examId="
				+ examId + ", listenGrade=" + listenGrade + ", readingGrade="
				+ readingGrade + ", writingGrade=" + writingGrade
				+ ", spokenGrade=" + spokenGrade + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((eaxmTime == null) ? 0 : eaxmTime.hashCode());
		result = prime * result + ((examId == null) ? 0 : examId.hashCode());
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result
				+ ((levelEaxmCourse == null) ? 0 : levelEaxmCourse.hashCode());
		result = prime * result
				+ ((listenGrade == null) ? 0 : listenGrade.hashCode());
		result = prime * result
				+ ((readingGrade == null) ? 0 : readingGrade.hashCode());
		result = prime * result
				+ ((spokenGrade == null) ? 0 : spokenGrade.hashCode());
		result = prime * result
				+ ((studentId == null) ? 0 : studentId.hashCode());
		result = prime * result
				+ ((writingGrade == null) ? 0 : writingGrade.hashCode());
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
		LevelExamination other = (LevelExamination) obj;
		if (eaxmTime == null) {
			if (other.eaxmTime != null)
				return false;
		} else if (!eaxmTime.equals(other.eaxmTime))
			return false;
		if (examId == null) {
			if (other.examId != null)
				return false;
		} else if (!examId.equals(other.examId))
			return false;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		if (levelEaxmCourse == null) {
			if (other.levelEaxmCourse != null)
				return false;
		} else if (!levelEaxmCourse.equals(other.levelEaxmCourse))
			return false;
		if (listenGrade == null) {
			if (other.listenGrade != null)
				return false;
		} else if (!listenGrade.equals(other.listenGrade))
			return false;
		if (readingGrade == null) {
			if (other.readingGrade != null)
				return false;
		} else if (!readingGrade.equals(other.readingGrade))
			return false;
		if (spokenGrade == null) {
			if (other.spokenGrade != null)
				return false;
		} else if (!spokenGrade.equals(other.spokenGrade))
			return false;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		if (writingGrade == null) {
			if (other.writingGrade != null)
				return false;
		} else if (!writingGrade.equals(other.writingGrade))
			return false;
		if (yearTerm == null) {
			if (other.yearTerm != null)
				return false;
		} else if (!yearTerm.equals(other.yearTerm))
			return false;
		return true;
	}
	
	
}
