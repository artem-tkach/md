package io.skai.accounting.mappers;

import io.skai.accounting.dto.user.UserRequestDto;
import io.skai.accounting.dto.user.UserResponseDto;
import io.skai.accounting.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserRequestDto dto);

    UserResponseDto toUserResponseDto(User user);

    List<UserResponseDto> toUserResponseDtoList(List<User> users);
}
