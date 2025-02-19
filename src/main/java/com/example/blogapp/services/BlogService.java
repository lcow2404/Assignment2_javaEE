package com.example.blogapp.services;


import com.example.blogapp.models.Blog;
import com.example.blogapp.models.BlogPost;

import java.util.List;
import java.util.stream.Collectors;

public class BlogService {
    public static List<String> getPostsByAuthorAge(Blog blog, Integer age) {
        return blog.getPosts().stream()
                .filter(post -> blog.getContributors().stream()
                        .anyMatch(person -> person.getId().equals(post.getAuthorId()) && person.getAge().equals(age)))
                .map(BlogPost::getId)
                .collect(Collectors.toList());
    }
}
