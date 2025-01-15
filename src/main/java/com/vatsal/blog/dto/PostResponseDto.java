package com.vatsal.blog.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PostResponseDto {

    private String title;

    private String content;

    private Date addedDate;

    private CategoryResponseDto categoryResponseDto;

    private UserResponseDto userResponseDto;
}