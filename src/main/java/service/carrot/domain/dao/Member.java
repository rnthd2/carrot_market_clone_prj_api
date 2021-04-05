package service.carrot.domain.dao;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Description;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 회원
 * 1. 회원PK
 * 2. 아이디
 * 3. 비밀번호
 * 4. [동네]
 * 5. 이메일
 * 6. 전화번호
 * 7. [판매내역?]
 * 8. [구매내역?]
 */
@Entity
@Getter @Setter
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_pk_id")
    private Long id;

    @NotNull
    @Column(name = "member_id")
    private Long member_id;

    @NotNull
    @Column(name = "member_pw")
    private String pw;

    @NotNull
    @Column(name = "member_name")
    private String name;

    private String email;

    @NotNull
    private String phone_number;

}
