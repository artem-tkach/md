package io.skai.accounting.service.impl;

import io.skai.accounting.dto.user.UserRequestDto;
import io.skai.accounting.dto.user.UserDto;
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
    public UserDto create(final UserRequestDto dto) {
        return null;
    }

    @Override
    public List<UserDto> getAll() {
        return null;
    }
}
