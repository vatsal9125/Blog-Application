package com.vatsal.blog.service;

import com.vatsal.blog.dto.UserRequestDto;
import com.vatsal.blog.dto.UserResponseDto;

import java.util.List;

public interface UserService {


    UserResponseDto createUser(UserRequestDto userRequestDto);

    UserResponseDto getUserById(Integer userId);

    UserResponseDto updateUser(UserRequestDto userRequestDto,Integer userId);

    void deleteUser(Integer userId);

    List<UserResponseDto> getAllUsers();

}
