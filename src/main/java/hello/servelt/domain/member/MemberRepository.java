package hello.servelt.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap,AtomicLong 사용 고려
        */

//ctrl+shift+t
public class MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }
    //싱글톤으로 만들때는 아무나 생성자를 만들수 없도록 private으로 막아주어야 한다
    private MemberRepository(){

    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }

}
