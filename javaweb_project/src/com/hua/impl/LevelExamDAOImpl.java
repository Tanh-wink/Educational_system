package com.hua.impl;

import java.util.List;

import com.hua.dao.DAO;
import com.hua.dao.LevelExamDAO;
import com.hua.entity.LevelExam;

public class LevelExamDAOImpl extends DAO<LevelExam> implements LevelExamDAO {

	@Override
	public List<LevelExam> getAll() {
		String sql = "SELECT * FROM levelExam;";
		return getForList(sql);
	}

	@Override
	public LevelExam get(String courseId) {
		String sql = "select *from levelExam where courseId = ?";
		return get(sql, courseId);
	}

	@Override
	public void insert(LevelExam levelExam) {
		String sql = "insert into levelExam values(?,?,?,?,?,?)";
		update(sql , levelExam.getYearTerm(), levelExam.getCourseId(), levelExam.getCourseName(), 
				levelExam.getApplyTime(), levelExam.getExamTime(),levelExam.getExamCost());

	}

	@Override
	public void update(LevelExam levelExam) {
		String sql = "update levelExam set YearTerm = ?,CourseName = ?, ApplyTime = ?, " +
				"ExamTime = ?, ExamCost = ? where courseId = ?";
		update(sql, levelExam.getYearTerm(), levelExam.getCourseName(), levelExam.getApplyTime(), 
				levelExam.getExamTime(),levelExam.getExamCost(), levelExam.getCourseId() );

	}

	@Override
	public void delete(String courseId) {
		String sql = "delete from levelExam where courseId = ?";
		update(sql, courseId);
	}

	@Override
	public long getCountWithName(String courseId) {
		
		return 0;
	}

	@Override
	public List<LevelExam> getAllWithYearTerm(String yearTerm) {
		String sql = "SELECT * FROM levelExam where yearTerm = ?;";
		return getForList(sql, yearTerm);
	}

	@Override
	public LevelExam get(String courseId, String yearTerm) {
		String sql = "select *from levelExam where courseId = ? and yearTerm = ?";
		return get(sql, courseId, yearTerm);
	}

}
