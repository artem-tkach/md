package io.skai.accounting.service;

import io.skai.accounting.dto.user.UserDto;
import io.skai.accounting.dto.user.UserRequestDto;

import java.util.List;

public interface UserService {

    UserDto create(UserRequestDto dto);

    List<UserDto> getAll();
}
