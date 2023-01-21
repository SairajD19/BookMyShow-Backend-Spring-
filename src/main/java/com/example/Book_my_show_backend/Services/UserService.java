package com.example.Book_my_show_backend.Services;

import com.example.Book_my_show_backend.Models.UserEntity;
import com.example.Book_my_show_backend.Repositories.UserRepository;
import com.example.Book_my_show_backend.RequestDTOs.UserDTO;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String createUser(UserDTO userDTO){
        UserEntity user = UserEntity.builder().name(userDTO.getName()).mobile(userDTO.getMobile()).build();
        try{
            userRepository.save(user);
        }catch (Exception e){
            return "User Creation Failed";
        }
        return "User Created Successfully!";
    }
}
