package com.vatsal.blog.service;

import com.vatsal.blog.dto.PostRequestDto;
import com.vatsal.blog.dto.PostResponseDto;

import java.util.List;

public interface PostService {
    PostResponseDto createPost(PostRequestDto postRequestDto);

    PostResponseDto getPostById(Long postId);

    List<PostResponseDto> getAllPosts();

    PostResponseDto updatePost(Long postId, PostRequestDto postRequestDto);

    void deletePost(Long postId);
}
