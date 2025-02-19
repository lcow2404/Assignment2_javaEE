package com.example.blogapp.models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
import java.util.stream.Collectors;


@Getter
@ToString
@EqualsAndHashCode
@Builder
@Jacksonized
public class Blog {
    private final List<BlogPost> posts;
    private final List<Person> contributors;

    public List<String> getPostsByAuthorAge(Integer age) {
        return posts.stream()
                .filter(post -> contributors.stream()
                        .anyMatch(person -> person.getId().equals(post.getAuthorId()) && person.getAge().equals(age)))
                .map(BlogPost::getId)
                .collect(Collectors.toList());
    }
}
