package service.carrot;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import service.carrot.domain.dao.Area;
import service.carrot.domain.dao.Post;
import service.carrot.domain.dao.PostCategory;
import service.carrot.domain.dao.PostStatus;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDB {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService{

        private final EntityManager em;

        public void dbInit1() {
            Post post = createPost(1L, "제목", "본문", 1000L, Area.SEJONG, PostCategory.BEAUTY, PostStatus.SALE);
            em.persist(post);
        }

        private Post createPost(Long id, String title, String mainText, Long price, Area area, PostCategory postCategory, PostStatus postStatus) {
            Post post1 = Post.ByRegistBuilder()
                    .title("제목")
                    .mainText("본문")
                    .price(1000L)
                    .area(Area.BUSAN)
                    .postCategory(PostCategory.BOOK_AND_TICKET_AND_REOCORD)
                    .postStatus(PostStatus.SALE)
                    .postPhotos(null)
                    .build();
            return post1;
        }

    }

}
