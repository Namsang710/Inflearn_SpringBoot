package spring.ex1.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import spring.ex1.member.Grade;
import spring.ex1.member.Member;
import spring.ex1.member.MemberService;
import spring.ex1.member.MemberServiceImpl;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000); 

    }
}
