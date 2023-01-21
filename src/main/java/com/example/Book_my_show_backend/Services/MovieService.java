package com.example.Book_my_show_backend.Services;

import com.example.Book_my_show_backend.Models.MovieEntity;
import com.example.Book_my_show_backend.Repositories.MovieRepository;
import com.example.Book_my_show_backend.RequestDTOs.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
