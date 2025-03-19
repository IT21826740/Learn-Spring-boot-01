package lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.responseDto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowBookListResponse {

    @Column(name = "borrow-books")
    private List<BorrowBookResponseDto> borrowBooks;

}
