package org.example.book_my_show.services;

import org.example.book_my_show.exceptions.ShowNotFoundException;
import org.example.book_my_show.exceptions.UserNotFoundException;
import org.example.book_my_show.models.*;
import org.example.book_my_show.repositories.ShowRepository;
import org.example.book_my_show.repositories.ShowSeatRepository;
import org.example.book_my_show.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    public BookingService(UserRepository userRepository, ShowRepository showRepository, ShowSeatRepository showSeatRepository){
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
    }

    public Booking bookMovie(Long userId,Long showId, List<Long> showSeatIds)throws UserNotFoundException, ShowNotFoundException {
        /*Steps involved in booking a movie

        * Get the user with userId
        * Get the show with showId
        * Get the list of show seats with showSeatIds
        * check if all the seats are available or not
        * if yes,proceed with booking
        * if not, throw an exception
        * ---------------Take a lock--------------------------------
        * Check if all the seats are available or not
        * change the seat status to blocked
        * ---------------Release the lock---------------------------
        * Create the booking and move to the payment page
        *
        */
        // To prevent null pointer exception we use optional instead of list
        // fetch user data from database
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("User not found with userId: "+userId);
        }
        User user = optionalUser.get();

        // fetch show data from database
        Optional<Show> optionalShow = showRepository.findById(showId);
        if(optionalShow.isEmpty()){
            throw new ShowNotFoundException("Show not found with showId: "+showId);
        }

        Show show = optionalShow.get();

        // fetch seats data for the show from database
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);

        for(ShowSeat showSeat:showSeats){
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new RuntimeException("Seat with seatId: "+showSeat.getId()+" is not available");
            }
        }

        for(ShowSeat showSeat:showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            showSeatRepository.save(showSeat);
        }

        //Create the booking and move to the payment page
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setShowSeats(showSeats);
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setCreatedAt(new Date());
        //calculate price
        return booking;
    }

}
