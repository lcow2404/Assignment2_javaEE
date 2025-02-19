package com.example.blogapp.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            // Load JSON files using class loader
            InputStream personStream = Main.class.getClassLoader().getResourceAsStream("person.json");
            InputStream blogPostsStream = Main.class.getClassLoader().getResourceAsStream("blogPosts.json");

            if (personStream == null || blogPostsStream == null) {
                System.err.println("Error: JSON files not found in resources.");
                return;
            }

            List<Person> people = mapper.readValue(personStream, new TypeReference<>() {});
            List<BlogPost> posts = mapper.readValue(blogPostsStream, new TypeReference<>() {});

            Blog blog = Blog.builder().posts(posts).contributors(people).build();

            System.out.println("Blog Data: ");
            System.out.println(blog);

            List<String> postsBy25 = blog.getPostsByAuthorAge(25);
            System.out.println("\nPosts by authors aged 25:");
            System.out.println(postsBy25);

            System.out.println("\nTotal blog posts: " + blog.getPosts().size());
            System.out.println("Total contributors: " + blog.getContributors().size());
        } catch (IOException e) {
            System.err.println("Error reading JSON files: " + e.getMessage());
        }
    }
}
