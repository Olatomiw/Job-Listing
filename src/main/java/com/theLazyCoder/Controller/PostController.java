package com.theLazyCoder.Controller;

import com.theLazyCoder.Model.Post;
import com.theLazyCoder.PostRepository;
import com.theLazyCoder.SearchRepository;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class PostController {

    final
    PostRepository postRepository;

    final
    SearchRepository searchRepository;

    public PostController(PostRepository postRepository, SearchRepository searchRepository) {
        this.postRepository = postRepository;
        this.searchRepository = searchRepository;
    }

    @Operation(hidden = true)
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }


    @GetMapping("posts")
    public List<Post> getAllPost(){
        return postRepository.findAll();
    }

    @PostMapping("/post")
    public Post addPost(@RequestBody Post post){
       return postRepository.save(post);
    }

    @GetMapping("posts/{text}")
    public List<Post> search(@PathVariable String text){
        return searchRepository.findByText(text);
    }
}
