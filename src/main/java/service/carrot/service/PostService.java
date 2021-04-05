package service.carrot.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.carrot.api.PostController;
import service.carrot.domain.dao.*;
import service.carrot.repository.MemberRepository;
import service.carrot.repository.PostRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public Post findById(Long id) {
        return postRepository.findById(id);
    }

    //todo area.code별 조회 필요
    //todo qQuery 추가 필요
    @Transactional(readOnly = true)
    public List<Post> findPostList(String code) {
        return postRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
    }

    public Long registPost(Post post) {
        em.persist(post);
        return post.getId();
    }

    public List<Long> updatePostList(List<Post> postList) {
        return postList.stream()
            .map(post -> updatePost(post))
            .collect(Collectors.toList());

    }

    public Long updatePost(Post post) {
        Post findPost = postRepository.findById(post.getId());
        findPost.setTitle(post.getTitle());
        findPost.setMainText(post.getMainText());
        findPost.setPostCategory(post.getPostCategory());
        findPost.setPostStatus(post.getPostStatus());
        findPost.setArea(post.getArea());
        findPost.setPrice(post.getPrice());
        findPost.setPostPhotos(post.getPostPhotos());
        return findPost.getId();
    }

    public Long deletePost(Long id) {
        postRepository.deleteById(id);
        return id;
    }

//    @Transactional //default readOnly false라 읽기 전용이 아닌경우 이렇게

}
