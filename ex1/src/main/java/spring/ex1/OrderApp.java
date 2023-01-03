package spring.ex1;

import spring.ex1.member.Grade;
import spring.ex1.member.Member;
import spring.ex1.member.MemberService;
import spring.ex1.member.MemberServiceImpl;
import spring.ex1.order.Order;
import spring.ex1.order.OrderService;
import spring.ex1.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);

    }
}
