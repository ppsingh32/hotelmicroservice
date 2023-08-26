package com.userservice.mapper;

import com.userservice.dto.UserRequestDto;
import com.userservice.dto.UserResponseDto;
import com.userservice.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userRequestDtoToUser(UserRequestDto userRequestDto);

    UserResponseDto userToUserResponseDto(User user);
}
