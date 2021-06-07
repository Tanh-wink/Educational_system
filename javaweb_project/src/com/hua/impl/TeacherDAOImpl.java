package com.hua.impl;

import java.util.List;

import com.hua.dao.DAO;
import com.hua.dao.TeacherDAO;
import com.hua.entity.Teacher;

public class TeacherDAOImpl extends DAO<Teacher> implements TeacherDAO {
	
	@Override
	public List<Teacher> getAll() {
		
		String sql = "SELECT * FROM teacherinformation;";
		return getForList(sql);
	}

	@Override
	public Teacher get(String teacherId) {
		String sql = "select *from teacherinformation where teacherId = ?";
		return get(sql, teacherId);
	}

	@Override
	public void insert(Teacher teacher) {
		String sql = "insert into teacherinformation values(?,?,?,?,?,?,?,?,?,?,?)";
		update(sql , teacher.getTeacherId(), teacher.getTeacherName(), teacher.getGender(), 
				teacher.getPoliticstatus(), teacher.getNation(),teacher.getNativeplace(), 
				teacher.getAcademy(),teacher.getProfession(),teacher.getPhone(),
				teacher.getEmail(),teacher.getAddress());

	}

	@Override
	public void update(Teacher teacher) {
		String sql = "update teacherinformation set TeacherName = ?,Gender = ?, Politicstatus = ?, " +
				"Nation = ?, Nativeplace = ?, Academy = ?, Profession = ?, Phone = ?, Email = ?," +
				"Address = ? where teacherId = ?";
		update(sql, teacher.getTeacherName(), teacher.getGender(), 
				teacher.getPoliticstatus(), teacher.getNation(),teacher.getNativeplace(), 
				teacher.getAcademy(),teacher.getProfession(),teacher.getPhone(),
				teacher.getEmail(),teacher.getAddress(),teacher.getTeacherId());

	}

	@Override
	public void delete(String teacherId) {
		String sql = "delete from teacherinformation where teacherId = ?";
		update(sql, teacherId);
	}

	@Override
	public long getCountWithName(String teacherId) {
		String sql = "select count(*) from teacherinformation where teacherId = ?";
		return getForValue(sql, teacherId);
	}

	
}
