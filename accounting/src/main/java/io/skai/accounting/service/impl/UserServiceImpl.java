package io.skai.accounting.service.impl;

import io.skai.accounting.dto.user.UserRequestDto;
import io.skai.accounting.dto.user.UserResponseDto;
import io.skai.accounting.mappers.UserMapper;
import io.skai.accounting.model.User;
import io.skai.accounting.repository.UserRepository;
import io.skai.accounting.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public User save(User user) {
        log.debug("Calling save user");
        return userRepository.save(user);
    }

    @Override
    public UserResponseDto create(UserRequestDto dto) {
        User user = userMapper.toUser(dto);
        User savedUser = userRepository.save(user);
        log.debug(savedUser.toString());
        return userMapper.toUserResponseDto(savedUser);
    }

    @Override
    public List<UserResponseDto> getAll() {
        log.debug("Call find all");
        return userMapper.toUserResponseDtoList(userRepository.findAll());
    }
}
