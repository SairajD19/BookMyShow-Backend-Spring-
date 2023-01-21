package com.example.Book_my_show_backend.Controllers;

import com.example.Book_my_show_backend.RequestDTOs.MovieDTO;
import com.example.Book_my_show_backend.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/create_movie")
    public String createMovie(@RequestBody()MovieDTO movieDTO){
        return movieService.createMovie(movieDTO);
    }
}
