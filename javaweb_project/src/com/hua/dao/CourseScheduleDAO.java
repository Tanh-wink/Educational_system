package com.hua.dao;

import java.util.List;

import com.hua.entity.CourseSchedule;

public interface CourseScheduleDAO {
	public List<CourseSchedule> getAll();
	
	public CourseSchedule get(String studentId);
	
	public void insert(CourseSchedule courseSchedule);
	
	public void update(CourseSchedule courseSchedule);
	
	public void delete(String studentId);
	
	/**
	 * 返回和studentId相等的记录数
	 * @param studentId
	 * @return
	 */
	public long getCountWithName(String studentId);
	
	/**
	 * 返回和studentId、yearTerm、week相等的记录
	 * @param studentId
	 * @param yearTerm
	 * @param week
	 * @return
	 */
	public List<CourseSchedule> getAllWithYearTerm(String studentId,
			String yearTerm, String week);
}
