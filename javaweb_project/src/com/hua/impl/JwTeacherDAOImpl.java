package com.hua.impl;

import java.util.List;

import com.hua.dao.DAO;
import com.hua.dao.JwTeacherDAO;
import com.hua.entity.JwTeacher;

public class JwTeacherDAOImpl extends DAO<JwTeacher> implements JwTeacherDAO {
	
	@Override
	public List<JwTeacher> getAll() {
		
		String sql = "SELECT * FROM jwteacherinformation;";
		return getForList(sql);
	}

	@Override
	public JwTeacher get(String teacherId) {
		String sql = "select *from jwteacherinformation where teacherId = ?";
		return get(sql, teacherId);
	}

	@Override
	public void insert(JwTeacher teacher) {
		String sql = "insert into jwteacherinformation values(?,?,?,?,?,?,?,?,?,?,?)";
		update(sql , teacher.getTeacherId(), teacher.getTeacherName(), teacher.getGender(), 
				teacher.getPoliticstatus(), teacher.getNation(),teacher.getNativeplace(), 
				teacher.getAcademy(),teacher.getQq(),teacher.getPhone(),
				teacher.getEmail(),teacher.getAddress());

	}

	@Override
	public void update(JwTeacher teacher) {
		String sql = "update jwteacherinformation set TeacherName = ?,Gender = ?, Politicstatus = ?, " +
				"Nation = ?, Nativeplace = ?, Academy = ?, qq = ?, Phone = ?, Email = ?," +
				"Address = ? where teacherId = ?";
		update(sql, teacher.getTeacherName(), teacher.getGender(), 
				teacher.getPoliticstatus(), teacher.getNation(),teacher.getNativeplace(), 
				teacher.getAcademy(),teacher.getQq(),teacher.getPhone(),
				teacher.getEmail(),teacher.getAddress(),teacher.getTeacherId());

	}

	@Override
	public void delete(String teacherId) {
		String sql = "delete from jwteacherinformation where teacherId = ?";
		update(sql, teacherId);
	}

	@Override
	public long getCountWithName(String teacherId) {
		String sql = "select count(*) from jwteacherinformation where teacherId = ?";
		return getForValue(sql, teacherId);
	}

	
}
