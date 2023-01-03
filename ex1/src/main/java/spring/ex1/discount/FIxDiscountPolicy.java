package spring.ex1.discount;

import spring.ex1.member.Grade;
import spring.ex1.member.Member;

public class FIxDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }else{
            return 0;
        }
    }
}
