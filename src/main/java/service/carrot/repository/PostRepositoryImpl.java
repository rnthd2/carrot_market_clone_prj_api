package service.carrot.repository;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import service.carrot.domain.dao.Post;
import service.carrot.domain.dao.QPost;

import java.util.List;

public class PostRepositoryImpl extends QuerydslRepositorySupport implements CustomPostRepository{

    public PostRepositoryImpl(){
        super(Post.class);
    }

    @Override
    public List<Post> findAllByAreaCode(String code) {
        QPost qPost = QPost.post;

        return null;
    }
}
