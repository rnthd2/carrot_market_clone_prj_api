package service.carrot.api;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.carrot.domain.dao.Member;
import service.carrot.service.MemberService;

import java.util.List;

@RestController // @Controller + @ResponseBody
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/memberList")
    public List<Member> getMemberListV1(){
        return memberService.findMemberList();
    }

    /**
     * 회원가입
     * @param member
     * @return
     */
    @PostMapping("/member")
    public MemberResponse joinMemberV1(@RequestBody @Validated Member member) {
        Long id = memberService.join(member);
        return new MemberResponse(id);
    }

    /**
     * 로그인
     * @param
     * @return
     */
    /*@PostMapping("/api/v1/login/member")
    public MemberResponse loginMemberV1(@RequestBody @Validated Member member) {
        Long id = memberService.login(member);
        return new MemberResponse(id);
    }*/

    class MemberResponse {
        private Long id;

        public MemberResponse(Long id) {
            this.id = id;
        }
    }

}


