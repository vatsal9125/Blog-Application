package com.vatsal.blog.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponseDto {

    private String categoryTitle;

    private String categoryDescription;
}
