package com.example.Book_my_show_backend.RequestDTOs;

import com.example.Book_my_show_backend.Models.ShowSeatEntity;
import lombok.Data;

import java.util.List;

@Data
public class BookTicketDTO {

    private List<String> requestedSeats;

    private int showId;

    private int userId;
}
