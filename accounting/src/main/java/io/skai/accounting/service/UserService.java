package io.skai.accounting.service;

import io.skai.accounting.dto.user.UserRequestDto;
import io.skai.accounting.dto.user.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserDto create(UserRequestDto dto);

    List<UserDto> getAll();
}
