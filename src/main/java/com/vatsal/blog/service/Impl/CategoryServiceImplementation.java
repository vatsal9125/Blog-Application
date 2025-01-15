package com.vatsal.blog.service.Impl;

import com.vatsal.blog.dto.CategoryRequestDto;
import com.vatsal.blog.dto.CategoryResponseDto;
import com.vatsal.blog.entity.Category;
import com.vatsal.blog.exceptions.ResourceNotFoundException;
import com.vatsal.blog.repo.CategoryRepository;
import com.vatsal.blog.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImplementation implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImplementation(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto) {
        Category category = Category.builder()
                .categoryTitle(categoryRequestDto.getCategoryTitle())
                .categoryDescription(categoryRequestDto.getCategoryDescription())
                .build();
        categoryRepository.save(category);

        return CategoryResponseDto.builder()
                .categoryTitle(category.getCategoryTitle())
                .categoryDescription(category.getCategoryDescription())
                .build();
    }

    @Override
    public CategoryResponseDto updateCategory(CategoryRequestDto categoryRequestDto, Integer categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException());

        category.setCategoryTitle(categoryRequestDto.getCategoryTitle());
        category.setCategoryDescription(categoryRequestDto.getCategoryDescription());
        Category updatedCategory = categoryRepository.save(category);

        return CategoryResponseDto.builder()
                .categoryTitle(updatedCategory.getCategoryTitle())
                .categoryDescription(updatedCategory.getCategoryDescription())
                .build();
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException());
        categoryRepository.delete(category);
    }

    @Override
    public CategoryResponseDto getCategory(Integer categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException());

        return CategoryResponseDto.builder()
                .categoryTitle(category.getCategoryTitle())
                .categoryDescription(category.getCategoryDescription())
                .build();
    }

    @Override
    public List<CategoryResponseDto> getCategories() {
        List<Category> categories = categoryRepository.findAll();

        return categories.stream()
                .map(category -> CategoryResponseDto.builder()
                        .categoryTitle(category.getCategoryTitle())
                        .categoryDescription(category.getCategoryDescription())
                        .build())
                .toList();
    }
}
