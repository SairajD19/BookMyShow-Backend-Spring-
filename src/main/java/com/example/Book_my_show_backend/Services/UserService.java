package com.example.Book_my_show_backend.Services;

import com.example.Book_my_show_backend.Models.TicketEntity;
import com.example.Book_my_show_backend.Models.UserEntity;
import com.example.Book_my_show_backend.ReponseDTOs.BookedTickets;
import com.example.Book_my_show_backend.Repositories.UserRepository;
import com.example.Book_my_show_backend.RequestDTOs.UserDTO;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String createUser(UserDTO userDTO){
        UserEntity user = UserEntity.builder().name(userDTO.getName()).mobile(userDTO.getMobile()).build();
        try{
            userRepository.save(user);
        }catch (Exception e){
            return "User Creation Failed";
        }
        return "User Created Successfully!";
    }

    public List<BookedTickets> printTickets(int userId){

        UserEntity user = userRepository.findById(userId).get();
        List<BookedTickets> bookedTickets = new ArrayList<>();
        TicketEntity ticket = user.getListOfTickets().get(user.getListOfTickets().size()-1);
        //for(TicketEntity ticket: tickets){
            BookedTickets bookedTickets1 = BookedTickets.builder().movieName(ticket.getShow().getMovie().getMovieName()).allotedSeats(ticket.getAllotedSeats()).cost(ticket.getAmount()).theaterName(ticket.getShow().getTheater().getName()).showDate(ticket.getShow().getShowDate()).showTime(ticket.getShow().getShowTime()).build();
            bookedTickets.add(bookedTickets1);
        //}
        return bookedTickets;
    }
}
