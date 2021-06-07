package com.hua.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hua.entity.Teacher;
import com.hua.impl.TeacherDAOImpl;

public class TeacherDAOImplTest {
	
	TeacherDAOImpl tdi = new TeacherDAOImpl();
	Teacher t = new Teacher("123456", "林英", "男", "党员", "汉族", "计算机学院", "计算机科学与技术",
			"广东广州", "15626438856","123th@126.com", "广州市越秀区");
	
	@Test
	public void testGetAll() {
		System.out.println(tdi.getAll());
	}

	@Test
	public void testGetString() {
		System.out.println(tdi.get("123456"));;
	}

	@Test
	public void testInsert() {
		tdi.insert(t);
	}

	@Test
	public void testUpdateTeacher() {
		t.setGender("女");
		tdi.update(t);
	}

	@Test
	public void testDelete() {
		tdi.delete("123456");
	}

	@Test
	public void testGetCountWithName() {
		fail("Not yet implemented");
	}

}
