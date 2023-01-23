package com.example.Book_my_show_backend.Models;

import com.example.Book_my_show_backend.Enums.SeatTypes;
import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "theater_seat")
@Data
@NoArgsConstructor
public class TheaterSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int rate;

    private String seatNo;
    @Enumerated(value = EnumType.STRING)
    private SeatTypes seatType;


    @ManyToOne
    @JoinColumn
    private TheaterEntity theater;

    public TheaterSeatEntity(String seatNo, SeatTypes seatType, int rate) {
        this.rate = rate;
        this.seatNo = seatNo;
        this.seatType = seatType;
    }
}
