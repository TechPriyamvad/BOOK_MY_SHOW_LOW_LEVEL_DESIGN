package org.example.book_my_show.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.book_my_show.models.User;

@Getter
@Setter
public class SignupResponseDto {
    private User user;
    private ResponseStatus responseStatus;
}
