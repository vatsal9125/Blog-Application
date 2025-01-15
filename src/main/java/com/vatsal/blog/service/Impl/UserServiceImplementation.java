package com.vatsal.blog.service.Impl;

import com.vatsal.blog.entity.User;
import com.vatsal.blog.exceptions.ResourceNotFoundException;
import com.vatsal.blog.dto.UserRequestDto;
import com.vatsal.blog.dto.UserResponseDto;
import com.vatsal.blog.repo.UserRepository;
import com.vatsal.blog.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository; // constructor Injection
    UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {

        User user = requestDtoToUser(userRequestDto);
        userRepository.save(user);

        return userToResponseDto(user);
    }

    @Override
    public UserResponseDto getUserById(Integer userId) {
       User user= this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException());
       return userToResponseDto(user);
    }

    @Override
    public UserResponseDto updateUser(UserRequestDto userRequestDto, Integer userId) {
        User user= this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        user.setUsername(userRequestDto.getUsername());
        this.userRepository.save(user);
        return userToResponseDto(user);

    }

    @Override
    public void deleteUser(Integer userId) {
        User user=this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException());
        this.userRepository.delete(user);

    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return List.of();
    }


    private User requestDtoToUser(UserRequestDto userRequestDto){
        User user = new User();
        user.setUsername(userRequestDto.getUsername());
        user.setPassword(userRequestDto.getPassword());
        user.setEmail(userRequestDto.getEmail());
        return user;
    }
    private UserResponseDto userToResponseDto(User user){
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setUsername(user.getUsername());
        userResponseDto.setPassword(user.getPassword());
        userResponseDto.setEmail(user.getEmail());
        return userResponseDto;
    }
}
