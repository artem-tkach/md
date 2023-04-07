package io.skai.accounting.service.impl;

import io.skai.accounting.dto.user.UserDto;
import io.skai.accounting.dto.user.UserRequestDto;
import io.skai.accounting.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    @Override
    public UserDto create(final UserRequestDto dto) {
        throw new UnsupportedOperationException("ip process");
    }

    @Override
    public List<UserDto> getAll() {
        throw new UnsupportedOperationException("ip process");
    }
}
