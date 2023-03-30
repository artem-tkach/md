package io.skai.accounting.service.impl;

import io.skai.accounting.dto.user.UserRequestDto;
import io.skai.accounting.dto.user.UserResponseDto;
import io.skai.accounting.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserServiceImpl implements UserService {

    @Override
    public UserResponseDto create(UserRequestDto dto) {
        return null;
    }

    @Override
    public List<UserResponseDto> getAll() {
        return null;
    }
}
