package service.carrot.domain.dao;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPost is a Querydsl query type for Post
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPost extends EntityPathBase<Post> {

    private static final long serialVersionUID = 1255743604L;

    public static final QPost post = new QPost("post");

    public final EnumPath<Area> area = createEnum("area", Area.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath mainText = createString("mainText");

    public final EnumPath<PostCategory> postCategory = createEnum("postCategory", PostCategory.class);

    public final ListPath<PostPhotos, QPostPhotos> postPhotos = this.<PostPhotos, QPostPhotos>createList("postPhotos", PostPhotos.class, QPostPhotos.class, PathInits.DIRECT2);

    public final EnumPath<PostStatus> postStatus = createEnum("postStatus", PostStatus.class);

    public final NumberPath<Long> price = createNumber("price", Long.class);

    public final StringPath title = createString("title");

    public QPost(String variable) {
        super(Post.class, forVariable(variable));
    }

    public QPost(Path<? extends Post> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPost(PathMetadata metadata) {
        super(Post.class, metadata);
    }

}

