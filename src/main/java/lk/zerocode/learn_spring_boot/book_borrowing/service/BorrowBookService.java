package lk.zerocode.learn_spring_boot.book_borrowing.service;

import lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.requestDto.BorrowBookRequestDto;
import lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.responseDto.BorrowBookResponseDto;

import java.util.List;

public interface BorrowBookService {
    void create(BorrowBookRequestDto borrowBookRequestDto);
    List<BorrowBookResponseDto> findAll();
}
