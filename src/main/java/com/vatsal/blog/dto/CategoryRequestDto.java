package com.vatsal.blog.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CategoryRequestDto {
    @NotBlank
    @Size(min = 4, message = "Min size of category title is 4")
    private String categoryTitle;

    @NotBlank
    @Size(min = 10, message = "min size of cateogry desc is 10")
    private String categoryDescription;

}
