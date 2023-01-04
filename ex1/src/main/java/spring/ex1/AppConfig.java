package spring.ex1;

import spring.ex1.discount.DiscountPolicy;
import spring.ex1.discount.FIxDiscountPolicy;
import spring.ex1.discount.RateDiscountPolicy;
import spring.ex1.member.MemberRepository;
import spring.ex1.member.MemberService;
import spring.ex1.member.MemberServiceImpl;
import spring.ex1.member.MemoryMemberRepository;
import spring.ex1.order.OrderService;
import spring.ex1.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
//        return new FIxDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
