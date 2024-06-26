package org.example.book_my_show.controllers;

import org.example.book_my_show.dtos.ResponseStatus;
import org.example.book_my_show.dtos.SignUpRequestDto;
import org.example.book_my_show.dtos.SignupResponseDto;
import org.example.book_my_show.models.User;
import org.example.book_my_show.services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignupResponseDto signUp(SignUpRequestDto requestDto) {
        SignupResponseDto responseDto = new SignupResponseDto();

        try {
            User user = userService.signUp(requestDto.getName(),
                    requestDto.getEmail(),
                    requestDto.getPassword());

            responseDto.setUser(user);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }

        return responseDto;
    }
}
