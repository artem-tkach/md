package io.skai.accounting.service;

import io.skai.accounting.dto.user.UserRequestDto;
import io.skai.accounting.dto.user.UserResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserResponseDto create(final UserRequestDto dto);

    List<UserResponseDto> getAll();
}
