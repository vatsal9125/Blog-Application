package com.vatsal.blog.dto;

import com.vatsal.blog.entity.Category;
import com.vatsal.blog.entity.User;
import jakarta.persistence.*;

import java.util.Date;

public class PostRequestDto {



    private String title;

    private String content;


    private Date addedDate;

    private CategoryResponseDto categoryResponseDto;


    private UserResponseDto userResponseDto;

}
