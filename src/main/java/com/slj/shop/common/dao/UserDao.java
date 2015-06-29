package com.slj.shop.common.dao;

import com.slj.shop.common.bean.User;

public interface UserDao {
  
  User findUserByUsername(String username); 
}