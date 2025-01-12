package com.deloitte.lms.dao;

import com.deloitte.lms.model.User;

public interface UserInterfaceDAO {
public User getUser(String userid);
public boolean deleteUser(String userid);
public User updateAge(String userid,int newAge);
}
