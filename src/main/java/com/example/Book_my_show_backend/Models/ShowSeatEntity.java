package com.example.Book_my_show_backend.Models;

import com.example.Book_my_show_backend.Enums.SeatTypes;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "show_seats")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ShowSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(nullable = false)
    private String seatNo;
    @Enumerated(value = EnumType.STRING)
    private SeatTypes seatType;

    private boolean booked;

    private Date bookedAt;


    @ManyToOne
    @JoinColumn
    private TicketEntity ticket;

    @ManyToOne
    @JoinColumn
    private ShowEntity show;
}
