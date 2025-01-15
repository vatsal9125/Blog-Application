package com.vatsal.blog.controller;

import com.vatsal.blog.dto.CategoryRequestDto;
import com.vatsal.blog.dto.CategoryResponseDto;
import com.vatsal.blog.payload.ApiResponse;
import com.vatsal.blog.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {


    private final CategoryService categoryService;
    CategoryController (CategoryService categoryService){
        this.categoryService = categoryService;
    }

    // create
    @PostMapping("/")
    public ResponseEntity<CategoryResponseDto> createCategory(@Valid @RequestBody CategoryRequestDto categoryRequestDto) {
        CategoryResponseDto categoryResponseDto = this.categoryService.createCategory(categoryRequestDto);
        return new ResponseEntity<CategoryResponseDto>(categoryResponseDto, HttpStatus.CREATED);
    }

    // update

    @PutMapping("/{catId}")
    public ResponseEntity<CategoryResponseDto> updateCategory(@Valid @RequestBody CategoryRequestDto categoryRequestDto,
                                                              @PathVariable int catId) {

        CategoryResponseDto updatedCategory = this.categoryService.updateCategory(categoryRequestDto, catId);
        return new ResponseEntity<CategoryResponseDto>(updatedCategory, HttpStatus.OK);
    }

    // delete
    @DeleteMapping("/{catId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId) {
        this.categoryService.deleteCategory(catId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted successfully !!", true),
                HttpStatus.OK);
    }
    // get

    @GetMapping("/{catId}")
    public ResponseEntity<CategoryResponseDto> getCategory(@PathVariable Integer catId) {

        CategoryResponseDto categoryResponseDto = this.categoryService.getCategory(catId);

        return new ResponseEntity<CategoryResponseDto>(categoryResponseDto, HttpStatus.OK);

    }

    // get all
    @GetMapping("/")
    public ResponseEntity<List<CategoryResponseDto>> getCategories() {
        List<CategoryResponseDto> categories = this.categoryService.getCategories();
        return ResponseEntity.ok(categories);
    }

}