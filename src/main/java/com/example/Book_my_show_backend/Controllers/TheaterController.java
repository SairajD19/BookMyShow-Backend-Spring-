package com.example.Book_my_show_backend.Controllers;

import com.example.Book_my_show_backend.RequestDTOs.TheaterDTO;
import com.example.Book_my_show_backend.Services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theater")
public class TheaterController {


    @Autowired
    TheaterService theaterService;

    @PostMapping("/create_theater")
    public String createTheater(@RequestBody()TheaterDTO theaterDTO){
        return theaterService.createTheater(theaterDTO);
    }
}
