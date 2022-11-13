package com.example.testspringboot.presentation;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.testspringboot.persistence.UserRepository;
import com.example.testspringboot.CreateUserDto;
import com.example.testspringboot.UserDto;
import com.example.testspringboot.persistence.User;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    //localhost:8888/users
    public ResponseEntity<UserDto> create(@RequestBody CreateUserDto dto) {

        final User user = new User();
        user.setName(dto.getName());
        user.setLastName(dto.getLastName());

        final User savedUser = userRepository.save(user);


        final UserDto responseDto = new UserDto();
        responseDto.setId(savedUser.getId());
        responseDto.setName(savedUser.getName());
        responseDto.setLastName(savedUser.getLastName());

        return ResponseEntity.ok(responseDto);
    }
    
}




