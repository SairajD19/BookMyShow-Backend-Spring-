package com.example.Book_my_show_backend.RequestDTOs;

import lombok.Data;

import java.util.Date;

@Data
public class MovieDTO {


    private String name;

    private int duration;
    private Date releaseDate;
}
