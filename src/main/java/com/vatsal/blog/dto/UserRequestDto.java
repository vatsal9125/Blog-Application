package com.vatsal.blog.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
public class UserRequestDto {


    @NotEmpty
    @Size(min = 3, max = 12 , message = "Username should have minimum of 3 characters and maximum of 12 characters")
    private String username;

    @Email(message = "Email Address is not valid")
    private String email;

    @NotEmpty
    @Size(min=3,max = 12, message = "Password should be minimum of 3 characters and maximum of 12 characters")
    private String password;




}
