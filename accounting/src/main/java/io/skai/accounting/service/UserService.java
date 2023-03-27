package io.skai.accounting.service;

import io.skai.accounting.dto.user.UserRequestDto;
import io.skai.accounting.dto.user.UserResponseDto;
import io.skai.accounting.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User save(User user);

    UserResponseDto create(UserRequestDto dto);

    List<UserResponseDto> getAll();
}
