package lk.zerocode.learn_spring_boot.book_borrowing.repository;

import lk.zerocode.learn_spring_boot.book_borrowing.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
