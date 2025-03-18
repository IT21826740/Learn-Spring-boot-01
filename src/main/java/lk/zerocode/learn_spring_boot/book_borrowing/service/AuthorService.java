package lk.zerocode.learn_spring_boot.book_borrowing.service;

import lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.requestDto.AuthorRequestDto;
import lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.responseDto.AuthorResponseDto;

import java.util.List;

public interface AuthorService {
    void create(AuthorRequestDto authorRequestDto);
    List<AuthorResponseDto> findAll();
    AuthorResponseDto findById(Long id);

}
