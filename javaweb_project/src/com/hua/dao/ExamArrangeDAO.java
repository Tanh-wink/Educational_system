package com.hua.dao;

import java.util.List;

import com.hua.entity.ExamArrange;

public interface ExamArrangeDAO {
	public List<ExamArrange> getAll();
	
	public List<ExamArrange> getAllWithStudentId(String studentId);
	
	public void insert(ExamArrange examArrange);
	
	public void update(ExamArrange examArrange);
	
	public void delete(String studentId);
	
	/**
	 * 返回和studentId相等的记录数
	 * @param studentId
	 * @return
	 */
	public long getCountWithName(String studentId);
	
	/**
	 * 返回和studentId、yearTerm相等的记录
	 * @param studentId
	 * @param yearTerm
	 * @param week
	 * @return
	 */
	public List<ExamArrange> getAllWithYearTerm(String studentId,
			String yearTerm);
}
