package spring.ex1.member;

public interface MemberRepository {

    void save(Member member);

    Member findByID(Long memberId);
}
