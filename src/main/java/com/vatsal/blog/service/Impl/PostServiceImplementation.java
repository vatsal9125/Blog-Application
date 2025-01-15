package com.vatsal.blog.service.Impl;

import com.vatsal.blog.dto.PostRequestDto;
import com.vatsal.blog.dto.PostResponseDto;
import com.vatsal.blog.service.PostService;

import java.util.List;

public class PostServiceImplementation implements PostService {
    @Override
    public PostResponseDto createPost(PostRequestDto postRequestDto) {
        return null;
    }

    @Override
    public PostResponseDto getPostById(Long postId) {
        return null;
    }

    @Override
    public List<PostResponseDto> getAllPosts() {
        return List.of();
    }

    @Override
    public PostResponseDto updatePost(Long postId, PostRequestDto postRequestDto) {
        return null;
    }

    @Override
    public void deletePost(Long postId) {

    }
}
