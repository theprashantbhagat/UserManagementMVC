package com.usermanagment.service.impl;

import com.usermanagment.constant.UserConstant;
import com.usermanagment.model.User;
import com.usermanagment.repository.UserRepository;
import com.usermanagment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public Boolean saveUser(User user) {

        user.setIsActive(UserConstant.IS_ACTIVE);
        User newUser = userRepository.save(user);
        if (newUser != null && newUser.getUserId() != null) {
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAllUsers() throws Exception {
        List<User> allUsers = this.userRepository.findAll();
        if (allUsers.size() == 0) {
            throw new Exception("No User Found In DataBase");
        }

        return allUsers;
    }

    @Override
    public User getSingleUser(Integer userId) {

        Optional<User> user = this.userRepository.findById(userId);
//       this.userRepository.save(user.get());
        if (user.isPresent()) {
            return user.get();
        }

        return null;
    }

    @Override
    public Boolean deleteUser(Integer userId) {
        Optional<User> user = this.userRepository.findById(userId);

        if(user.isPresent()) {
            User user1 = user.get();
            user1.setIsActive(UserConstant.NOT_ACTIVE);
            userRepository.save(user1);
            return true;
        }
        return false;

    }
}
