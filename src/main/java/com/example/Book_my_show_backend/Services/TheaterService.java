package com.example.Book_my_show_backend.Services;

import com.example.Book_my_show_backend.Enums.SeatTypes;
import com.example.Book_my_show_backend.Models.TheaterEntity;
import com.example.Book_my_show_backend.Models.TheaterSeatEntity;
import com.example.Book_my_show_backend.Repositories.TheaterRepository;
import com.example.Book_my_show_backend.Repositories.TheaterSeatRepository;
import com.example.Book_my_show_backend.RequestDTOs.TheaterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    TheaterRepository theaterRepository;
    @Autowired
    TheaterSeatRepository theaterSeatRepository;

    public String createTheater(TheaterDTO theaterDTO){

        try {
            TheaterEntity theater = TheaterEntity.builder().name(theaterDTO.getName()).city(theaterDTO.getCity()).address(theaterDTO.getAddress()).build();
            List<TheaterSeatEntity> seats = createSeats();
            theater.setListOfTheaterSeats(seats);

            for (TheaterSeatEntity theaterSeat : seats) {
                theaterSeat.setTheater(theater);
            }
            theaterRepository.save(theater);
        }catch (Exception e){
            return "Failed to Create Theater";
        }
        return "Theater Created Successfully";

    }

    public List<TheaterSeatEntity> createSeats(){
        List<TheaterSeatEntity> seats = new ArrayList<>();

        for(int i=0;i<5;i++){
            char ch = (char)('A'+i);
            String seatNo  = "1"+ ch;
            TheaterSeatEntity theaterSeat = new TheaterSeatEntity(seatNo, SeatTypes.CLASSIC,100);
            seats.add(theaterSeat);
        }
        for(int i=0;i<5;i++){
            char ch = (char)('A'+i);
            String seatNo  = "2"+ ch;
            TheaterSeatEntity theaterSeat = new TheaterSeatEntity(seatNo,SeatTypes.VIP,200);
            seats.add(theaterSeat);
        }
        theaterSeatRepository.saveAll(seats);
        return seats;
    }
}
