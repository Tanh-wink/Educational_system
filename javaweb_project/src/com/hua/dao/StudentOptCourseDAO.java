package com.hua.dao;

import java.util.List;
import com.hua.entity.StudentOptCourse;

public interface StudentOptCourseDAO {
	public List<StudentOptCourse> getAll();
	
	public StudentOptCourse get(String studentId);
	
	public List<StudentOptCourse> getAll(String studentId);
	
	public StudentOptCourse get(StudentOptCourse studentOptCourse);
	
	public void insert(StudentOptCourse studentOptCourse);
	
	public void update(StudentOptCourse studentOptCourse);
	
	public void delete(String studentId);
	
	/**
	 * 返回和studentId相等的记录数
	 * @param studentId
	 * @return
	 */
	public long getCountWithName(String studentId);
	
}
