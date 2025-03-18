package lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.responseDto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponseDto {

    private Long id;
    private String name;

}
