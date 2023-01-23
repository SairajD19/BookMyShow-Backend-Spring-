package com.example.Book_my_show_backend.Controllers;

import com.example.Book_my_show_backend.ReponseDTOs.TheaterResponse;
import com.example.Book_my_show_backend.RequestDTOs.TheaterDTO;
import com.example.Book_my_show_backend.Services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theater")
public class TheaterController {


    @Autowired
    TheaterService theaterService;

    @PostMapping("/create_theater")
    public String createTheater(@RequestBody()TheaterDTO theaterDTO){
        return theaterService.createTheater(theaterDTO);
    }

    @GetMapping("/theaters_with_movie")
    public List<TheaterResponse> findTheaters(@RequestParam("movieName")String movieName) throws Exception {
        return theaterService.theaterWithMovie(movieName);
    }
}
