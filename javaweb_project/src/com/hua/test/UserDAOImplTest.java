package com.hua.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hua.entity.User;
import com.hua.impl.UserDAOImpl;

public class UserDAOImplTest {
	UserDAOImpl udi = new UserDAOImpl();
	
	@Test
	public void testGetAll() {
		
		System.out.println(udi.getAll());
	}

	@Test
	public void testGet() {
		String username = "3115001256";
		
		System.out.println(udi.get(username));
	}

	@Test
	public void testInsert() {
		User user = new User();
		
		udi.insert(user);
	}

	@Test
	public void testUpdate() {
		User user = new User();
		
		udi.update(user);
	}

	@Test
	public void testDelete() {
		udi.delete("3115001273");
	}

	@Test
	public void testGetCountWithName() {
		fail("Not yet implemented");
	}

}
