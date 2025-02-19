package com.example.blogapp.models;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;
import java.util.List;

@Getter
@ToString
@EqualsAndHashCode
@Builder
@Jacksonized
public class Blog {
    private final List<BlogPost> posts;
    private final List<Person> contributors;
}

