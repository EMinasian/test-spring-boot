package com.example.testspringboot.presentation;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.testspringboot.persistence.UserRepository;
import com.example.testspringboot.CreateUserDto;
import com.example.testspringboot.UserDto;
import com.example.testspringboot.persistence.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    // localhost:8888/users
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

    @GetMapping("/users")
    // 127.0.0.1:8888/users
    public ResponseEntity<?> getUsers() {

        // List<UserDto> user = userRepository.findAll();
        List<User> users = userRepository.findAll();

        if (users != null) {
            List<UserDto> result = (List<UserDto>) users.stream().map(u -> UserDto.builder()
                    .name(u.getName())
                    .lastName(u.getLastName()));

            if(result != null) {
                return ResponseEntity.status(HttpStatus.OK).body(result);
            }
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}

