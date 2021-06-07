package com.hua.dao;

import java.util.List;

import com.hua.entity.ExemptionApply;

public interface ExemptionApplyDAO {
	
	public List<ExemptionApply> getAll();
	
	public ExemptionApply get(String studentId);
	
	public void insert(ExemptionApply exemptionApply);
	
	public void update(ExemptionApply exemptionApply);
	
	public void delete(String studentId);
}
