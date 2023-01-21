package com.example.Book_my_show_backend.Controllers;

import com.example.Book_my_show_backend.RequestDTOs.UserDTO;
import com.example.Book_my_show_backend.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create_user")
    public String createUser(@RequestBody() UserDTO userDTO){
        return userService.createUser(userDTO);
    }
}
