package lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookLIstResponse {
    private List<BookResponseDto> books;
}
