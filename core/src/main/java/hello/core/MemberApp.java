package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        // ApplicationContext가 스프링 컨테이너라고 보면됨
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // 첫번째 매개변수는 꺼내올 Bean(COnfig 파일에 메서드 이름으로 컨테이너에 등록됨), 두번쨰 매개변수는 타입
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);

//        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
