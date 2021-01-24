package com.accolite.restapi_au.service;

import com.accolite.restapi_au.entity.User;

public interface UserService {
    public User addUser(User user);

    public User getUserById(Integer id);
    
    public User update(Integer id, User user);
    
    public String deleteUserById(Integer id);
}
