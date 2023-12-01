package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // 인터페이스에 구현체를 넣어준다
    // 안그러면 null 난다
    MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
