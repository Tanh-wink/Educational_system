package com.hua.dao;

import java.util.List;

import com.hua.entity.OptionalCourse;

public interface OptionalCourseDAO {
	public List<OptionalCourse> getAll();
	
	public OptionalCourse get(String courseId);
	
	public OptionalCourse get(String courseId, String yearTerm);
	
	public void insert(OptionalCourse optionalCourse);
	
	public void update(OptionalCourse optionalCourse);
	
	public void delete(String courseId);
	
	/**
	 * 返回和studentId相等的记录数
	 * @param courseId
	 * @return
	 */
	public long getCountWithName(String courseId);
	
	/**
	 * 返回和yearTerm相等的记录
	 * @param yearTerm
	 * @return
	 */
	public List<OptionalCourse> getAllWithYearTerm(String yearTerm);
}
