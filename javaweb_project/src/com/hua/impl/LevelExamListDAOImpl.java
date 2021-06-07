package com.hua.impl;

import java.util.List;

import com.hua.dao.DAO;
import com.hua.dao.LevelExamListDAO;
import com.hua.entity.LevelExamList;

public class LevelExamListDAOImpl extends DAO<LevelExamList> implements LevelExamListDAO {

	@Override
	public List<LevelExamList> getAll() {
		String sql = "SELECT * FROM levelExamlist;";
		return getForList(sql);
	}

	@Override
	public LevelExamList get(String studentId) {
		String sql = "select *from levelExamlist where studentId = ?";
		return get(sql, studentId);
	}

	@Override
	public void insert(LevelExamList levelExamList) {
		String sql = "insert into levelExamlist values(?,?)";
		update(sql , levelExamList.getStudentId(),levelExamList.getCourseId());

	}

	@Override
	public void update(LevelExamList levelExamList) {
		String sql = "update levelExamlist set CourseId = ? where studentId = ?";
		update(sql, levelExamList.getCourseId(), levelExamList.getStudentId() );

	}

	@Override
	public void delete(String studentId) {
		String sql = "delete from levelExamlist where studentId = ?";
		update(sql, studentId);
	}

	@Override
	public long getCountWithName(String studentId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public LevelExamList get(LevelExamList levelExamList) {
		String sql = "select *from levelExamlist where studentId = ? and courseId = ?";
		return get(sql, levelExamList.getStudentId(), levelExamList.getCourseId());
	}

	@Override
	public List<LevelExamList> getAll(String studentId) {
		String sql = "SELECT * FROM levelExamlist where studentId = ?;";
		return getForList(sql, studentId);
	}


}
