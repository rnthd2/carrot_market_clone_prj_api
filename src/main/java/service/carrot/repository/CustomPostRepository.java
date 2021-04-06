package service.carrot.repository;

import org.springframework.stereotype.Repository;
import service.carrot.domain.dao.Area;
import service.carrot.domain.dao.Post;

import java.util.List;

@Repository
public interface CustomPostRepository {
    List<Post> findAllByAreaCode(String code);
    Long save(Post post);
}
