package spring.ex1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.ex1.discount.DiscountPolicy;
import spring.ex1.discount.RateDiscountPolicy;
import spring.ex1.member.MemberRepository;
import spring.ex1.member.MemberService;
import spring.ex1.member.MemberServiceImpl;
import spring.ex1.member.MemoryMemberRepository;
import spring.ex1.order.OrderService;
import spring.ex1.order.OrderServiceImpl;


@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FIxDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
