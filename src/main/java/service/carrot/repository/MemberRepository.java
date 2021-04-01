package service.carrot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import service.carrot.domain.dao.Member;

import java.util.List;

@Repository
@Transactional
public interface MemberRepository extends JpaRepository<Member, Long> {

    /**
     * findBy*** 의 룰에 따라
     * select m from Member m where m.name = ? 로 조회
     * 강력하다...!
     */
    List<Member> findByName(String name);

    List<Member> findAll();

//    Member findByIdAndPW(Long id, String pw);

}
