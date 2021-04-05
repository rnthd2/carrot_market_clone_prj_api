package service.carrot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.carrot.domain.dao.Member;
import service.carrot.repository.MemberRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private static Member member;

    private final MemberRepository memberRepository;

    public List<Member> findMemberList() {
        return memberRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
    }

    @Transactional //default readOnly false라 읽기 전용이 아닌경우 이렇게
    public Long join(Member member){
        validateDuplicateMember(member);    //중복 회원 검증 로직
        memberRepository.save(member);
        return member.getId();
    }
    private void validateDuplicateMember(Member member){
        //아래 비즈니스 로직을 실무에서 돌릴때
        //멀티쓰레드인 경우 db충돌이 일어날 수 있기 때문에 member name 을 unique 할 필요가 있다
        List<Member> findMemberList = memberRepository.findByName(member.getName());

        if (!findMemberList.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니당.");
        }
    }

    /*public Long login(Member member) {
        Member findMember = memberRepository.findByIdAndPW(member.getId(), member.getPw());

        if(findMember == null){
            throw new IllegalStateException("회원을 찾을 수 없습니당.");
        }

        return findMember.getId();
    }*/
}
