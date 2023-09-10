package http;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        PostService postService = new PostService();

// Liệt kê 10 bài viết ở trang thứ 2
        List<Post> posts = postService.list(2, 10);

// Tạo bài viết mới
        Post newPost = new Post();
        newPost.setTitle("Tiêu đề bài viết mới");
        newPost.setBody("Nội dung bài viết mới");
        Post createdPost = postService.create(newPost);

// Cập nhật bài viết
        int postId = 1;
        Post updatedPost = new Post();
        updatedPost.setTitle("Cập nhật tiêu đề");
        updatedPost.setBody("Cập nhật nội dung");
        Post result = postService.update(postId, updatedPost);

// Xóa bài viết
        int postIdDeleted = 2;
        Post deletedPost = postService.delete(postIdDeleted);

        System.out.println(posts);
    }
}