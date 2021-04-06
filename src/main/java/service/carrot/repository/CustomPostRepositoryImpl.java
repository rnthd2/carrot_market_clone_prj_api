package service.carrot.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import service.carrot.domain.dao.*;

import javax.persistence.EntityManager;
import java.util.List;

import static service.carrot.domain.dao.QMember.member;
import static service.carrot.domain.dao.QPost.post;
import static service.carrot.domain.dao.QPostPhotos.postPhotos;

@Repository
public class CustomPostRepositoryImpl extends QuerydslRepositorySupport implements CustomPostRepository{
    private final EntityManager em;
    private final JPAQueryFactory query;

    public CustomPostRepositoryImpl(EntityManager em){
        super(Post.class);
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    @Override
    public List<Post> findAllByAreaCode(String code) {
        Area area = Area.getAreaByAreaCode(code);
        BooleanExpression eq = post.area.eq(Area.BUSAN);
        List<Post> postList = query.select(post).from(post)
                .leftJoin(post.postPhotos, postPhotos).fetchJoin()
                .where(post.area.eq(area))
                .fetch();
        return postList;
    }

    @Override
    public Long save(Post post) {
        em.persist(post);
        return post.getId();
    }
}
