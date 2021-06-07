package com.hua.impl;

import java.util.List;

import com.hua.dao.DAO;
import com.hua.dao.StudentOptCourseDAO;
import com.hua.entity.StudentOptCourse;

public class StudentOptCourseDAOImpl extends DAO<StudentOptCourse> implements StudentOptCourseDAO {

	@Override
	public List<StudentOptCourse> getAll() {
		String sql = "SELECT * FROM StudentOptCourse;";
		return getForList(sql);
	}

	@Override
	public StudentOptCourse get(String studentId) {
		String sql = "select *from StudentOptCourse where studentId = ?";
		return get(sql, studentId);
	}

	@Override
	public void insert(StudentOptCourse studentOptCourse) {
		String sql = "insert into StudentOptCourse values(?,?)";
		update(sql , studentOptCourse.getStudentId(),studentOptCourse.getCourseId());

	}

	@Override
	public void update(StudentOptCourse studentOptCourse) {
		String sql = "update StudentOptCourse set CourseId = ? where studentId = ?";
		update(sql, studentOptCourse.getCourseId(), studentOptCourse.getStudentId() );

	}

	@Override
	public void delete(String studentId) {
		String sql = "delete from StudentOptCourse where studentId = ?";
		update(sql, studentId);
	}

	@Override
	public long getCountWithName(String studentId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public StudentOptCourse get(StudentOptCourse studentOptCourse) {
		String sql = "select *from StudentOptCourse where studentId = ? and courseId = ?";
		return get(sql, studentOptCourse.getStudentId(), studentOptCourse.getCourseId());
	}

	@Override
	public List<StudentOptCourse> getAll(String studentId) {
		String sql = "SELECT * FROM StudentOptCourse where studentId = ?;";
		return getForList(sql, studentId);
	}


}
