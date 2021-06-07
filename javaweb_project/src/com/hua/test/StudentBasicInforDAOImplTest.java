package com.hua.test;

import org.junit.Test;

import com.hua.entity.CriterStudent;
import com.hua.entity.StudentBasicInformation;
import com.hua.impl.StudentBasicInforDAOImpl;

public class StudentBasicInforDAOImplTest {
	StudentBasicInforDAOImpl sbi = new StudentBasicInforDAOImpl();
	StudentBasicInformation studentBasicInfor = new StudentBasicInformation(3115001256l,
			"Tan","男","2015级","15(1)班","自动化学院",
			"电子信息专业","大学城校区","15622365566","广东省湛江市霞山区人民大道");
	@Test
	public void testGetAll() {
		System.out.println(sbi.getAll());
	}

	@Test
	public void testGetLong() {
		System.out.println(sbi.get(3115001256l));
	}

	@Test
	public void testInsert() {
		sbi.insert(studentBasicInfor);
	}

	@Test
	public void testUpdateStudentBasicInformation() {
		StudentBasicInformation studentBasicInfor1 = new StudentBasicInformation(3115001256l,
				"Tan","男","2015级","15(2)班","自动化学院",
				"电子信息专业","大学城校区","15622369988","广东省湛江市霞山区人民大道");
		sbi.update(studentBasicInfor1);
	}

	@Test
	public void testDelete() {
		sbi.delete(3115001256l);
	}

	@Test
	public void testGetCountWithName() {
		CriterStudent student = new CriterStudent(null, "电子信息工程", null, null, null);
		
		System.out.println(sbi.getForListWithCriterStudent(student));
	}

}
