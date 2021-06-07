package com.hua.dao;

import java.util.List;

import com.hua.entity.Teacher;

public interface TeacherDAO {
	public List<Teacher> getAll();
	
	public Teacher get(String teacherId);
	
	public void insert(Teacher teacher);
	
	public void update(Teacher teacher);
	
	public void delete(String teacherId);
	
	/**
	 * 返回和teacherId相等的记录数
	 * @param teacherId
	 * @return
	 */
	public long getCountWithName(String teacherId);

}
