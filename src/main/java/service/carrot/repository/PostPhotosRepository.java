package service.carrot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import service.carrot.domain.dao.PostPhotos;

@Repository
@Transactional
public interface PostPhotosRepository extends JpaRepository<PostPhotos, Integer> {

    PostPhotos save(PostPhotos boardPicture);

//    List<PostPhotos> findAllByPk_id(Long pk_id);
}
