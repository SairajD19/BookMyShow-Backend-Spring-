package com.example.Book_my_show_backend.Services;

import com.example.Book_my_show_backend.Models.*;
import com.example.Book_my_show_backend.Repositories.MovieRepository;
import com.example.Book_my_show_backend.Repositories.ShowRepository;
import com.example.Book_my_show_backend.Repositories.ShowSeatRepository;
import com.example.Book_my_show_backend.Repositories.TheaterRepository;
import com.example.Book_my_show_backend.RequestDTOs.ShowDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    ShowRepository showRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheaterRepository theaterRepository;
    @Autowired
    ShowSeatRepository showSeatRepository;


    public String addShow(ShowDTO showDTO){
        ShowEntity show = ShowEntity.builder().showDate(showDTO.getShowDate()).showTime(showDTO.getShowTime()).multiplier(showDTO.getMultiplier()).build();

        MovieEntity movie = movieRepository.findByMovieName(showDTO.getMovieName());
        TheaterEntity theater = theaterRepository.findById(showDTO.getTheaterId()).get();

        show.setMovie(movie);
        show.setTheater(theater);

        movie.getShows().add(show);
        theater.getListOfShows().add(show);

        List<ShowSeatEntity> showSeats = createShowSeats(theater.getListOfTheaterSeats());

        show.setListOfShowSeats(showSeats);

        for(ShowSeatEntity showSeat: showSeats){
            showSeat.setShow(show);
        }
        movieRepository.save(movie);
        theaterRepository.save(theater);
        return "show added successfully";


    }

    public List<ShowSeatEntity> createShowSeats(List<TheaterSeatEntity> listOfShowSeats){

        List<ShowSeatEntity> seats = new ArrayList<>();
        for(TheaterSeatEntity theaterSeat: listOfShowSeats){
            ShowSeatEntity seat = ShowSeatEntity.builder().seatNo(theaterSeat.getSeatNo()).seatType(theaterSeat.getSeatType()).build();
            seats.add(seat);
        }
        showSeatRepository.saveAll(seats);
        return seats;
    }
}
