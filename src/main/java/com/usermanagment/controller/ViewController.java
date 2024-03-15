package com.usermanagment.controller;


import com.usermanagment.model.User;
import com.usermanagment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

    @Autowired
    private UserService userService;

    @GetMapping("/edit")
    public String editUser(@RequestParam("userId") Integer userId, Model model) {
        User user = this.userService.getSingleUser(userId);
        model.addAttribute("user", user);
        return "userInfo";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("userId") Integer userId, Model model) {

      this.userService.deleteUser(userId);
      return "redirect:viewAllUser";

    }

}
