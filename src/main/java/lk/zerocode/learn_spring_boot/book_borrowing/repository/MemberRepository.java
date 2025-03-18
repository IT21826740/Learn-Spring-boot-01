package lk.zerocode.learn_spring_boot.book_borrowing.repository;

import lk.zerocode.learn_spring_boot.book_borrowing.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Integer> {
    List<Member> id(Long id);

    Optional<Member> findById(Long id);

}
