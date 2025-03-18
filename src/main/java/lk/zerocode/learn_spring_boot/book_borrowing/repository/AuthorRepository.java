package lk.zerocode.learn_spring_boot.book_borrowing.repository;

import lk.zerocode.learn_spring_boot.book_borrowing.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
