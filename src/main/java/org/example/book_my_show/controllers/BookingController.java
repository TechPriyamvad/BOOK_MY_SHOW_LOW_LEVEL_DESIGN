package org.example.book_my_show.controllers;

import org.example.book_my_show.dtos.BookMovieResponseDto;
import org.example.book_my_show.dtos.BookMovieRequestDto;
import org.example.book_my_show.dtos.ResponseStatus;
import org.example.book_my_show.models.Booking;
import org.example.book_my_show.services.BookingService;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private BookingService bookingService;
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public BookMovieResponseDto bookMovie(BookMovieRequestDto bookMovieRequestDto){
        BookMovieResponseDto bookMovieResponseDto = new BookMovieResponseDto();
        try {
            Booking booking = bookingService.bookMovie(
                    bookMovieRequestDto.getUserId(),
                    bookMovieRequestDto.getShowId(),
                    bookMovieRequestDto.getShowSeatIds()
                    );
            bookMovieResponseDto.setBooking(booking);
            bookMovieResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch(Exception e){
            bookMovieResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return bookMovieResponseDto;
    }
}
