package com.hua.dao;

import java.util.List;

import com.hua.entity.CriterUser;
import com.hua.entity.User;

public interface UserDAO {
	
	public List<User> getAll();
	
	public User get(String username);
	
	public void insert(User user);
	
	public void update(User user);
	
	public void delete(String username);
	
	/**
	 * 返回和name相等的记录数
	 * @param name
	 * @return
	 */
	public long getCountWithName(String username);

	public List<User> getForListWithCriterCustomer(CriterUser user);
}
