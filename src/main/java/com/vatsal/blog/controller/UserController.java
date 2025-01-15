package com.vatsal.blog.controller;

import com.vatsal.blog.payload.ApiResponse;
import com.vatsal.blog.dto.UserRequestDto;
import com.vatsal.blog.dto.UserResponseDto;
import com.vatsal.blog.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto=userService.createUser(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Integer id,
                                                      @RequestBody @Valid UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto=userService.updateUser(userRequestDto,id);
        return new ResponseEntity<>(userResponseDto,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer id) {
        this.userService.deleteUser(id);
        return new ResponseEntity<>(new ApiResponse("Deleted",true),HttpStatus.OK);

    }

}
