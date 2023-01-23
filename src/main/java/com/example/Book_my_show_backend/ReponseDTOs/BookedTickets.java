package com.example.Book_my_show_backend.ReponseDTOs;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Builder
public class BookedTickets {

    public String movieName;

    public String theaterName;

    public String allotedSeats;

    public int cost;

    public LocalDate showDate;

    public LocalTime showTime;
}
