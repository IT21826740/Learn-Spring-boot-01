package lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponseDto {
    private Long id;
    private String name;
}
