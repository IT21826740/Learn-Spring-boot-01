package lk.zerocode.learn_spring_boot.book_borrowing.repository;

import lk.zerocode.learn_spring_boot.book_borrowing.model.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowBookRepository extends JpaRepository<BorrowBook,Long> {
}
