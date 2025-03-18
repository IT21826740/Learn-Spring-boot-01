package lk.zerocode.learn_spring_boot.book_borrowing.service;

import lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.requestDto.BookRequestDto;
import lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.responseDto.BookResponseDto;

import java.util.List;

public interface BookService {
    void create(BookRequestDto bookRequestDto) throws RuntimeException;

    List<BookResponseDto> findAll();
}
