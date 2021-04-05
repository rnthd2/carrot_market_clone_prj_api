package service.carrot.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import service.carrot.domain.dao.Post;

import java.util.List;

@Repository
@Transactional
public interface PostRepository extends JpaRepository<Post, Integer> {

    @Override
    List<Post> findAllById(Iterable<Integer> integers);

    Post findById(Long id);

    void deleteById(Long id);
}
