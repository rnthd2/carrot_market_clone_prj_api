package service.carrot.api;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import service.carrot.domain.dao.Post;
import service.carrot.domain.dao.PostStatus;
import service.carrot.service.PostService;

import java.util.List;
import java.util.stream.Collectors;

@RestController // @Controller + @ResponseBody
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/postList")
    public List<Post> getPostListV1(@RequestParam(value = "code") String code){
        return postService.findPostList(code);
    }

    @PostMapping("/post")
    public PostResponse postPostV1(@RequestBody @Validated Post post){
        Long id = postService.registPost(post);
        return new PostResponse(id);
    }

    @PutMapping("/post")
    public PostResponse putPostV1(@RequestBody @Validated Post post){
        Long id = postService.updatePost(post);
        return new PostResponse(id);
    }

    @DeleteMapping("/post")
    public PostResponse deletePostV1(@RequestParam Long id){
        postService.deletePost(id);
        return new PostResponse(id);
    }


//    @PutMapping("/postList")
//    public List<PostResponse> postPostListV1(@RequestBody @Validated List<Post> postList){
//        List<Long> ids = postService.updatePostList(postList);
//        return ids.stream()
//                .map(id -> new PostResponse(id))
//                .collect(Collectors.toList());
//    }


    @Data
    class PostResponse {
        private long id;

        public PostResponse(long id) {
            this.id = id;
        }
    }
}
