package org.example.book_my_show;

import org.example.book_my_show.controllers.UserController;
import org.example.book_my_show.dtos.SignUpRequestDto;
import org.example.book_my_show.dtos.SignupResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookMyShowApplication implements CommandLineRunner {
	@Autowired
	private UserController userController;
	public static void main(String[] args) {
		SpringApplication.run(BookMyShowApplication.class, args);
	}
	public void run(String... args)throws Exception{
		SignUpRequestDto requestDto = new SignUpRequestDto();
		requestDto.setName("John Doe");
		requestDto.setEmail("priyam459@h.com");
		requestDto.setPassword("password");

		SignupResponseDto responseDto = userController.signUp(requestDto);
	}
}
