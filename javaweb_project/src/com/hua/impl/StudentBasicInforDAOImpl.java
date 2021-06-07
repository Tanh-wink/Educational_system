package com.hua.impl;

import java.util.List;

import com.hua.dao.DAO;
import com.hua.dao.StudentBasicInforDAO;
import com.hua.entity.CriterStudent;
import com.hua.entity.StudentBasicInformation;

public class StudentBasicInforDAOImpl extends DAO<StudentBasicInformation> implements StudentBasicInforDAO {

	@Override
	public List<StudentBasicInformation> getAll() {
		String sql = "SELECT * FROM studentBasicInformation;";
		return getForList(sql);
	}

	@Override
	public StudentBasicInformation get(Long studentId) {
		String sql = "select *from studentBasicInformation where studentId = ?";
		return get(sql, studentId);
	}

	@Override
	public void insert(StudentBasicInformation studentBasicInfor) {
		String sql = "insert into studentBasicInformation " +
				"values(?,?,?,?,?,?,?,?,?,?)";
		update(sql , studentBasicInfor.getStudentId(), studentBasicInfor.getStudentName(), studentBasicInfor.getGender(),
				studentBasicInfor.getGrade(),studentBasicInfor.getClassName(),studentBasicInfor.getAcademy(),
				studentBasicInfor.getProfession(),studentBasicInfor.getCampus(),studentBasicInfor.getPhone(),
				studentBasicInfor.getHomeAddress());
	}

	@Override
	public void update(StudentBasicInformation studentBasicInfor) {
		String sql = "update studentbasicinformation set studentName = ?,gender = ?, grade = ?, className = ? ," +
				"academy = ?, profession = ?, campus = ?, phone = ?, homeAddress = ? where studentId = ?";
		update(sql, studentBasicInfor.getStudentName(), studentBasicInfor.getGender(),
				studentBasicInfor.getGrade(),studentBasicInfor.getClassName(),studentBasicInfor.getAcademy(),
				studentBasicInfor.getProfession(),studentBasicInfor.getCampus(),studentBasicInfor.getPhone(),
				studentBasicInfor.getHomeAddress(),studentBasicInfor.getStudentId());

	}

	@Override
	public void delete(Long studentId) {
		String sql = "delete from studentBasicInformation where studentId = ?";
		update(sql, studentId);
	}

	@Override
	public Integer getCountWithStudentId(Long studentId) {
		String sql = "select count(studentId) from studentBasicInformation where studentId = ?";
		return getForValue(sql,studentId);
	}

	@Override
	public List<StudentBasicInformation> getForListWithCriterStudent(CriterStudent student) {
		String sql = "select * from studentBasicInformation " +
				"where academy like ? and Profession like ? and ClassName like ? " +
				"and StudentName like ? and StudentId like ?";
		
		return getForList(sql, student.getAcademy(), student.getProfession(), student.getClassName(),
				student.getStudentName(),student.getStudentId());
	}

}
