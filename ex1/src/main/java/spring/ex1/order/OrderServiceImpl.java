package spring.ex1.order;

import spring.ex1.discount.DiscountPolicy;
import spring.ex1.discount.FIxDiscountPolicy;
import spring.ex1.member.Member;
import spring.ex1.member.MemberRepository;
import spring.ex1.member.MemoryMemberRepository;

public class OrderServiceImpl implements  OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FIxDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findByID(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
