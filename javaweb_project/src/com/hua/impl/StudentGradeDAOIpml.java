package com.hua.impl;

import java.util.List;

import com.hua.dao.DAO;
import com.hua.dao.StudentGradeDAO;
import com.hua.entity.StudentGrade;

public class StudentGradeDAOIpml extends DAO<StudentGrade> implements StudentGradeDAO {

	@Override
	public List<StudentGrade> getAll() {
		String sql = "SELECT * FROM studentGrade;";
		return getForList(sql);
	}

	@Override
	public List<StudentGrade> getAllCourseGrade(Long studentId){
		String sql = "SELECT * FROM studentGrade where studentId = ?;";
		return getForList(sql, studentId);
	}

	@Override
	public void insert(StudentGrade studentGrade) {
		String sql = "insert into studentGrade " +
				"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		update(sql ,studentGrade.getYearTerm(), studentGrade.getStudentId(), studentGrade.getStudentName(), 
				studentGrade.getCourseId(),studentGrade.getCourseName(),studentGrade.getScore(),studentGrade.getGradePoint(),
				studentGrade.getCredit(),studentGrade.getCourseClass(),studentGrade.getStudyWay(),studentGrade.getExamWay(),
				studentGrade.getGradeWay(),studentGrade.getEffectivity(),studentGrade.getRemarks());
	}

	@Override
	public void update(StudentGrade studentGrade) {
		String sql = "update studentGrade set yearTerm = ?, studentName = ?,courseId = ?, courseName = ?, " +
				"score = ? ,gradePoint = ? ,credit = ? ,courseClass = ? ,studyWay = ?, examWay = ?, " +
				"gradeWay = ?, effectivity = ?, remarks = ? where studentId = ?";
		update(sql ,studentGrade.getYearTerm(), studentGrade.getStudentName(), 
				studentGrade.getCourseId(),studentGrade.getCourseName(),studentGrade.getScore(),studentGrade.getGradePoint(),
				studentGrade.getCredit(),studentGrade.getCourseClass(),studentGrade.getStudyWay(),studentGrade.getExamWay(),
				studentGrade.getGradeWay(),studentGrade.getEffectivity(),studentGrade.getRemarks(), studentGrade.getStudentId());

	}

	@Override
	public void delete(Long studentId) {
		String sql = "delete from studentGrade where studentId = ?";
		update(sql, studentId);
	}

	@Override
	public Integer getCountWithStudentId(Long studentId) {
		String sql = "select count(studentId) from studentGrade where studentId = ?";
		return getForValue(sql,studentId);
	}

	@Override
	public List<StudentGrade> getAllWithYearTerm(Long studentId,
			String yearTerm) {
		String sql;
		
		if(yearTerm != null){
			sql = "SELECT * FROM studentGrade where yearTerm like '%" + yearTerm +"%' and studentId = ?;";
			return getForList(sql,studentId);
		}else{
			sql = "SELECT * FROM studentGrade where studentId = ?;";
			return getForList(sql,studentId);
		}
	}

}
