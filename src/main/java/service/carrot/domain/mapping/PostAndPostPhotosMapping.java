package service.carrot.domain.mapping;

import lombok.Getter;
import lombok.Setter;
import service.carrot.domain.dao.Post;
import service.carrot.domain.dao.PostPhotos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Getter
@Setter
public class PostAndPostPhotosMapping {
    @Id
    @GeneratedValue
    @Column(name = "post_and_postPhotos_pk_id")
    private Long pk_id;

    private Post post;

    private PostPhotos postPhotos;
}
