package service.carrot.domain.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * todo
 * 언더스코어는 이미 Spring Data JPA의 탐색 경로를 설정하는 예약어이기 때문에 Property Expressions에 사용하면 안된다.
 * 스네이크 표기법을 사용하기보단 자바의 네이밍 컨벤션인 카멜 표기법을 사용하는 것을 추천한다
 * https://velog.io/@pyo-sh/Spring-Boot-%ED%8C%8C%EC%9D%BC%EC%9D%B4%EB%AF%B8%EC%A7%80-%EC%97%85%EB%A1%9C%EB%93%9C-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0
 */
@Entity
@Getter
@Setter
public class PostPhotos {
    @Id
    @GeneratedValue
    @Column(name = "postPhotos_pk_id")
    private Long pk_id;

    private String original_file_name;

    private String stored_file_path;

    private long file_size;

    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_pk_id")
    private Post post; //주문 회원
}
