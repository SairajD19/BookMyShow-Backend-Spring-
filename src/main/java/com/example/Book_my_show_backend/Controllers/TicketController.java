package com.example.Book_my_show_backend.Controllers;

import com.example.Book_my_show_backend.RequestDTOs.BookTicketDTO;
import com.example.Book_my_show_backend.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/create_ticket")
    public String createTicket(@RequestBody() BookTicketDTO bookTicketDTO){
        try{
            return ticketService.createTicket(bookTicketDTO);
        }catch (Exception e){
            return "Some of Seats are not Available!";
        }
    }

    @PostMapping("/cancel_ticket")
    public String cancelTicket(@RequestParam("ticketId")int ticketId){
        ticketService.cancelTicket(ticketId);
        return "Ticket Cancelled Successfully!";
    }
}
