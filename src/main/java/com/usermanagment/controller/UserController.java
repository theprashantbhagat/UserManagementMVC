package com.usermanagment.controller;


import com.usermanagment.constant.UserConstant;
import com.usermanagment.model.User;
import com.usermanagment.properties.AppProperties;
import com.usermanagment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AppProperties appProperties;

    @GetMapping("/user")
    public String loadUserForm(Model model) {

        User user = new User();
        model.addAttribute("user", user);

        return "userInfo";
    }

    @PostMapping("/saveUsers")
    public String saveUsers(User user, Model model) {

        Boolean savedUser = userService.saveUser(user);

        Map<String, String> messages = appProperties.getMessages();

        if (savedUser) {
            model.addAttribute("Success", messages.get("saveSuccess"));
        } else {
            model.addAttribute("Fail", messages.get("saveFail"));
        }


        return "userInfo";

    }

    @GetMapping("/viewAllUser")
    public String getAllUsers(Model model) throws Exception {

        List<User> allUsers = this.userService.getAllUsers();
        List<User> users = allUsers.stream().filter(newUser -> newUser.getIsActive() == UserConstant.IS_ACTIVE)
                .collect(Collectors.toList());

        model.addAttribute("user", users);
        return "contact";

    }
    

    


}
