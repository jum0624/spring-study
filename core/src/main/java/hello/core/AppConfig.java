package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {  // 역할들이 드러나는 것이 중요!!


    // memberService -> new MemoryMemberRepository
    // orderService -> new MemoryMemberRepository
    // 두개의 객체가 생성 되면서 싱글톤이 아닌것인가?

    // 예상 출력
//    call AppConfig.memberService
//    call AppConfig.MemberRepository
//    call AppConfig.MemberRepository
//    call AppConfig.orderService
//    call AppConfig.MemberRepository

    // 실제 출력
//    call AppConfig.memberService
//    call AppConfig.MemberRepository
//    call AppConfig.orderService
// memberRepository가 세번 호출 되어야 하는데 한번만 호출됨 -> 스프링이 싱글톤을 보장해주고 있음을 볼 수 있음

//    @Autowired MemberRepository MemberRepository;

    @Bean
    public MemberService memberService() {  // 멤버 서비스의 역할
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());  // 생성자 주입
    }

    @Bean
    public MemberRepository memberRepository() {  // 멤버 레포지토리의 역할
        System.out.println("call AppConfig.MemberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){  // 주문 서비스의 역할
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {  // 주문 정책의 역할
        return new RateDiscountPolicy();
    }
}
