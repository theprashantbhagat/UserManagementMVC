package com.usermanagment.service;

import com.usermanagment.model.User;

import java.util.List;

public interface UserService {

    public Boolean saveUser(User user);

    public List<User>getAllUsers() throws Exception;

    public User getSingleUser(Integer userId);

    public Boolean deleteUser(Integer userId);


}
