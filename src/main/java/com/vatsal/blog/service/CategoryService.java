package com.vatsal.blog.service;

import com.vatsal.blog.dto.CategoryRequestDto;
import com.vatsal.blog.dto.CategoryResponseDto;

import java.util.List;

public interface CategoryService {
    // create
    CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto);

    // update
    CategoryResponseDto updateCategory(CategoryRequestDto categoryRequestDto, Integer categoryId);


    void deleteCategory(Integer categoryId);

    // get
    CategoryResponseDto getCategory(Integer categoryId);

    // get All

    List<CategoryResponseDto> getCategories();
}
