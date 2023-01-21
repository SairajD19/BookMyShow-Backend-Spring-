package com.example.Book_my_show_backend.RequestDTOs;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowDTO {

    private LocalDate showDate;

    private LocalTime showTime;

    private double multiplier;

    private String movieName;

    private int theaterId;
}
