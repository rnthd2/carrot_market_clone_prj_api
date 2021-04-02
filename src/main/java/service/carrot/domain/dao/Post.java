package service.carrot.domain.dao;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import service.carrot.domain.converter.AreaConverter;
import service.carrot.domain.converter.PostCategoryConverter;
import service.carrot.domain.converter.PostStatusConverter;

import javax.persistence.*;
import java.util.List;

/**
 * 1. 제목
 * 2. [사진]
 * 3. 가격
 * 4. 본문
 * 5. 카테고리
 * 6. 상품상태
 * 7. [작성자]
 * 8. [판매자]
 * 9. [구매자]
 * 10. 동네
 */
@Entity
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue
    @Column(name = "post_pk_id")
    private Long pk_id;

    @NotNull
    private String title;

    @NotNull
    private String mainText;

    @NotNull
    private Long price;

    @OneToMany(mappedBy = "post")
    private List<PostPhotos> postPhotos;

    private PostStatus postStatus;

    private PostCategory postCategory;

    private Area area;

}
