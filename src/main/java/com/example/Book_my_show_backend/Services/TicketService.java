package com.example.Book_my_show_backend.Services;

import com.example.Book_my_show_backend.Models.*;
import com.example.Book_my_show_backend.Repositories.MovieRepository;
import com.example.Book_my_show_backend.Repositories.ShowRepository;
import com.example.Book_my_show_backend.Repositories.TicketRepository;
import com.example.Book_my_show_backend.Repositories.UserRepository;
import com.example.Book_my_show_backend.RequestDTOs.BookTicketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    ShowRepository showRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TicketRepository ticketRepository;


    public String createTicket(BookTicketDTO bookTicketDTO) throws Exception{

        List<String> requestedSeats = bookTicketDTO.getRequestedSeats();
        ShowEntity show = showRepository.findById(bookTicketDTO.getShowId()).get();
        UserEntity user = userRepository.findById(bookTicketDTO.getUserId()).get();

        List<ShowSeatEntity> seats = show.getListOfShowSeats();

        List<ShowSeatEntity> bookedSeats = new ArrayList<>();


        for(ShowSeatEntity seat: seats){
            String seatNo = seat.getSeatNo();
            if(seat.isBooked()==false && requestedSeats.contains(seatNo)){
                bookedSeats.add(seat);
            }
        }
        if(bookedSeats.size()!=requestedSeats.size()){
            throw new Exception("Some or more seats booked already!");
        }

        String allotedSeat = "";
        double multiplier = show.getMultiplier();
        int amount = 0;
        TicketEntity ticket = new TicketEntity();

        for(ShowSeatEntity bookedSeat: bookedSeats){
            bookedSeat.setBookedAt(new Date());
            bookedSeat.setShow(show);
            bookedSeat.setTicket(ticket);
            bookedSeat.setBooked(true);

            allotedSeat = allotedSeat + bookedSeat.getSeatNo() + ", ";

            if(bookedSeat.getSeatNo().charAt(0)==1)
                amount = (int)(amount + (100*multiplier));
            else
                amount = (int)(amount + (200*multiplier));

        }

        ticket.setBookedAt(new Date());
        ticket.setShow(show);
        ticket.setAmount(amount);
        ticket.setUser(user);
        ticket.setListOfShowSeats(bookedSeats);
        ticket.setAllotedSeats(allotedSeat);

        ticketRepository.save(ticket);

        return "Ticket Booked!";

    }
}
