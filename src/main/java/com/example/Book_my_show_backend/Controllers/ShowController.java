package com.example.Book_my_show_backend.Controllers;

import com.example.Book_my_show_backend.Repositories.ShowSeatRepository;
import com.example.Book_my_show_backend.RequestDTOs.ShowDTO;
import com.example.Book_my_show_backend.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shows")
public class ShowController {

    @Autowired
    ShowService showService;

    @PostMapping("/add_show")
    public String addShow(@RequestBody ShowDTO showDTO){
        return showService.addShow(showDTO);
    }
}
