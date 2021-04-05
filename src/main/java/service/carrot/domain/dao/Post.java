package service.carrot.domain.dao;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.util.Assert;

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
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {
    @Id
    @GeneratedValue
    @Column(name = "post_pk_id")
    private Long id;

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

    @Builder(builderClassName = "ByRegistBuilder", builderMethodName = "ByRegistBuilder")
    public Post(Long id, String title, String mainText, Long price, Area area, PostCategory postCategory, PostStatus postStatus, List<PostPhotos> postPhotos) {
        Assert.notNull(title, "title must not be null");
        Assert.notNull(mainText, "mainText must not be null");
        Assert.notNull(price, "price must not be null");
        Assert.notNull(area, "area must not be null");
        Assert.notNull(postCategory, "postCategory must not be null");

        this.id = id;
        this.title = title;
        this.mainText = mainText;
        this.price = price;
        this.area = area;
        this.postPhotos = postPhotos;
        this.postCategory = postCategory;
        this.postStatus = postStatus;
    }

}
