package com.example.Book_my_show_backend.ReponseDTOs;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Builder
public class ShowsResponseDto {
    public String movieName;

    public String theaterName;

    public String city;

    public LocalDate showDate;

    public LocalTime showTime;
}
