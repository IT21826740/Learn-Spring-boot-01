package lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.requestDto;

import jakarta.persistence.*;
import lk.zerocode.learn_spring_boot.book_borrowing.model.Book;
import lk.zerocode.learn_spring_boot.book_borrowing.model.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowBookRequestDto {

    private Long book;
    private Long member;

}
