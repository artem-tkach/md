package io.skai.accounting.controller;

import io.skai.accounting.dto.user.UserRequestDto;
import io.skai.accounting.dto.user.UserDto;
import io.skai.accounting.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin
public class UsersController {
    private final UserService userService;

    @GetMapping
    List<UserDto> getAll() {
        return userService.getAll();
    }

    @PostMapping
    UserDto createUser(@RequestBody UserRequestDto dto) {
        return userService.create(dto);
    }
}
