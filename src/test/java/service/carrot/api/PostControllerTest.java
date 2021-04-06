package service.carrot.api;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import service.carrot.domain.dao.Area;
import service.carrot.domain.dao.Post;
import service.carrot.domain.dao.PostCategory;
import service.carrot.domain.dao.PostStatus;
import service.carrot.service.PostService;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.not;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class PostControllerTest {

    @Autowired
    PostController postController;

    @Autowired
    PostService postService;

    @Test
    void getPostListV1() {
        List<Post> postListV1 = postController.getPostListV1(Area.BUSAN.getCode());
        List<Area> areas = postListV1.stream()
                .map(post -> post.getArea())
                .filter(area -> !area.equals(Area.BUSAN))
                .collect(Collectors.toList());
        assertThat(areas.isEmpty());
    }

    @Test
    void postPostV1() {

        //given
        Post post1 = Post.ByRegistBuilder()
                .title("제목1-1")
                .mainText("본문1-1")
                .price(1000L)
                .area(Area.BUSAN)
                .postCategory(PostCategory.BOOK_AND_TICKET_AND_REOCORD)
                .postStatus(PostStatus.SALE)
                .postPhotos(null)
                .build();

        Post post2 = Post.ByRegistBuilder()
                .title("제목1-2")
                .mainText("본문1-2")
                .price(2000L)
                .area(Area.BUSAN)
                .postCategory(PostCategory.BOOK_AND_TICKET_AND_REOCORD)
                .postStatus(PostStatus.SALE)
                .postPhotos(null)
                .build();

        //when
        PostController.PostResponse post1Id = postController.postPostV1(post1);
        PostController.PostResponse post2Id = postController.postPostV1(post2);

        //then
        Post findPost1 = postService.findById(post1Id.getId());
        Post findPost2 = postService.findById(post2Id.getId());

        assertAll(
                () -> assertNotNull(findPost1),
                () -> assertNotNull(findPost2),
                () -> assertEquals(findPost1.getId(), post1Id.getId(), () -> "글을 처음 등록하면 동일한 id로 조회 되어야한다."),
                () -> assertEquals(findPost2.getId(), post2Id.getId(), () -> "글을 처음 등록하면 동일한 id로 조회 되어야한다."),
                () -> assertTrue(findPost1.getPostStatus()== PostStatus.SALE, () -> "글을 처음 등록하면 글 상태값이 SALES 여야한다.")
        );
    }

    @Test
    void postPostListV1() {
    }

    @Test
    void putPostV1() {
        //given
        Post post1Id = Post.ByRegistBuilder()
                .id(1L)
                .title("제목123")
                .mainText("본문123")
                .price(1000L)
                .area(Area.BUSAN)
                .postCategory(PostCategory.BOOK_AND_TICKET_AND_REOCORD)
                .postStatus(PostStatus.SALE)
                .postPhotos(null)
                .build();

        PostController.PostResponse postResponse = postController.putPostV1(post1Id);

        Post findPost1 = postService.findById(post1Id.getId());

        assertAll(
                () -> assertNotNull(postResponse),
                () -> assertNotNull(findPost1),
                () -> assertEquals(findPost1.getTitle(), post1Id.getTitle(), () -> "글을 수정하면 동일한 id로 조회 되어야한다.")
        );

    }

    @Test
    void deletePostV1() {
        PostController.PostResponse postResponse = postController.deletePostV1(1L);

        Post findPost1 = postService.findById(postResponse.getId());

        assertAll(
                () -> assertNull(findPost1)
        );
    }
}