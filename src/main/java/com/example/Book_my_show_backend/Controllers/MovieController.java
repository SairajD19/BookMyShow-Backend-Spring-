package com.example.Book_my_show_backend.Controllers;

import com.example.Book_my_show_backend.ReponseDTOs.ShowsResponseDto;
import com.example.Book_my_show_backend.RequestDTOs.MovieDTO;
import com.example.Book_my_show_backend.RequestDTOs.MovieShows;
import com.example.Book_my_show_backend.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/create_movie")
    public String createMovie(@RequestBody()MovieDTO movieDTO){
        return movieService.createMovie(movieDTO);
    }

    @GetMapping("/find_shows")
    public List<ShowsResponseDto> findShows(@RequestBody()MovieShows movieShows){
        return movieService.allShows(movieShows);
    }
}
