package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // 인터페이스에 구현체를 넣어준다
    // 안그러면 null 난다
//    MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;    // 이제 구현체가 코드내에서 없어졌다. 이렇게 됨으로써 추상화에만 의존 (DIP 지켜짐)

    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
