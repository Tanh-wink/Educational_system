package com.hua.dao;

import java.util.List;

import com.hua.entity.PostponeExamApply;

public interface PostponeExamApplyDAO {
	
	public List<PostponeExamApply> getAll();
	
	public PostponeExamApply get(String studentId);
	
	public void insert(PostponeExamApply postponeExamApply);
	
	public void update(PostponeExamApply postponeExamApply);
	
	public void delete(String studentId);
}
