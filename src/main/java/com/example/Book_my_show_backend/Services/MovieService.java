package com.example.Book_my_show_backend.Services;

import com.example.Book_my_show_backend.Models.MovieEntity;
import com.example.Book_my_show_backend.Models.ShowEntity;
import com.example.Book_my_show_backend.ReponseDTOs.ShowsResponseDto;
import com.example.Book_my_show_backend.Repositories.MovieRepository;
import com.example.Book_my_show_backend.RequestDTOs.MovieDTO;
import com.example.Book_my_show_backend.RequestDTOs.MovieShows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String createMovie(MovieDTO movieDTO){
        MovieEntity movie = MovieEntity.builder().movieName(movieDTO.getName()).duration(movieDTO.getDuration()).releaseDate(movieDTO.getReleaseDate()).build();
        try{
            movieRepository.save(movie);
        }catch (Exception e){
            return "Movie Creation Failed";
        }
        return "Movie Created!";
    }

    public List<ShowsResponseDto> allShows(MovieShows movieShows)throws Exception{

        MovieEntity movie = movieRepository.findByMovieName(movieShows.getMovieName());
        List<ShowEntity> shows = movie.getShows();
        List<ShowsResponseDto> showsAvailable = new ArrayList<>();
        for(ShowEntity show: shows){
            boolean flag = false;
            if(show.getShowDate().isBefore(movieShows.getToDate()) && show.getShowDate().isAfter(movieShows.getFromDate()))
                flag = true;
            else if(show.getShowDate().equals(movieShows.getFromDate()))
                flag = true;
            else if(show.getShowDate().equals(movieShows.getToDate()))
                flag = true;
            if(flag){
                ShowsResponseDto showsResponseDto = ShowsResponseDto.builder().city(show.getTheater().getCity()).theaterName(show.getTheater().getName()).movieName(movieShows.getMovieName()).showTime(show.getShowTime()).showDate(show.getShowDate()).build();
                showsAvailable.add(showsResponseDto);
            }
        }
        if(showsAvailable.isEmpty())
            throw new Exception("No shows available in dates!");
        return  showsAvailable;

    }
}
