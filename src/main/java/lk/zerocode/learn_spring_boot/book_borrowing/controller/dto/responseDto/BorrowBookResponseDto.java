package lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowBookResponseDto {
    private Long id;
    private BorrowedBookResponseDto book;
    private  MemberResponseDto member;
    private LocalDate borrowDate;
}
