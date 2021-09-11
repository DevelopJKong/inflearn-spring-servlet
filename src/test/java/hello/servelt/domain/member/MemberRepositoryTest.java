package hello.servelt.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
//junit4 에서는 public이 있어야 했지만 junit5 부터는 없어도 된다
class MemberRepositoryTest {
    //스프링을 사용하면 싱글톤을 사용할 필요가 없다 왜냐면 자체적으로 해주기 때문이다
    MemberRepository memberRepository = MemberRepository.getInstance();

    //테스트가 끝날때 마다 초기화
    //clearStore()를 꼭 해주어야 한다
    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save(){
        //given 어떤것이 주어졌을때
        Member member = new Member("hello",20);

        //when 어떤것이 실행했을때
        Member savedMember = memberRepository.save(member);

        //then 그 어떤것의 결과
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll(){
        //given
        Member member1 = new Member("member1",20);
        Member member2 = new Member("member2",30);

        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        List<Member> result = memberRepository.findAll();

        //then

        //만약에 여기서 static import를 disable로 한다면 설정에 들어가서 다시 해주어야 한다
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1,member2);
    }


}