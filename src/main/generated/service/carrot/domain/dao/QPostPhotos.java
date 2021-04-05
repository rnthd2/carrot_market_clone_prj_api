package service.carrot.domain.dao;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPostPhotos is a Querydsl query type for PostPhotos
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPostPhotos extends EntityPathBase<PostPhotos> {

    private static final long serialVersionUID = 1380281877L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPostPhotos postPhotos = new QPostPhotos("postPhotos");

    public final DateTimePath<java.time.LocalDateTime> dateTime = createDateTime("dateTime", java.time.LocalDateTime.class);

    public final StringPath file_content_type = createString("file_content_type");

    public final NumberPath<Long> file_size = createNumber("file_size", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath original_file_name = createString("original_file_name");

    public final QPost post;

    public final StringPath stored_file_path = createString("stored_file_path");

    public QPostPhotos(String variable) {
        this(PostPhotos.class, forVariable(variable), INITS);
    }

    public QPostPhotos(Path<? extends PostPhotos> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPostPhotos(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPostPhotos(PathMetadata metadata, PathInits inits) {
        this(PostPhotos.class, metadata, inits);
    }

    public QPostPhotos(Class<? extends PostPhotos> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.post = inits.isInitialized("post") ? new QPost(forProperty("post")) : null;
    }

}

