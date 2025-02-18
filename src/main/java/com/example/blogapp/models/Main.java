package com.example.blogapp.models;

public class Main {

    public static void main(String[] args) {
        // Create valid BlogPost
        try {
            BlogPost blogPost1 = new BlogPost("1", "author123", "This is a blog post content.");
            System.out.println(blogPost1);  // Output to console
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating BlogPost: " + e.getMessage());
        }

    }
}
