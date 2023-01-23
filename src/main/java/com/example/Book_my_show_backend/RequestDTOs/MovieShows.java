package com.example.Book_my_show_backend.RequestDTOs;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MovieShows {

    private String movieName;

    private LocalDate fromDate;

    private LocalDate toDate;
}
