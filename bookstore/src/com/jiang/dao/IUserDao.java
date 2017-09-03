package com.jiang.dao;

import com.jiang.entity.UserBean;

public interface IUserDao {

	void create(UserBean user) throws Exception;

	boolean existsName(String username)throws Exception;

	boolean login(UserBean user) throws Exception;

}
