package lk.zerocode.learn_spring_boot.book_borrowing.service;

import lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.requestDto.MemberRequestDto;
import lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.responseDto.MemberResponseDto;
import lk.zerocode.learn_spring_boot.book_borrowing.model.Member;

import java.util.List;

public interface MemberService {
    void create(MemberRequestDto memberRequestDto);
    List<MemberResponseDto> findAll();
    void update();
    void delete(Long id) throws Exception;
    MemberResponseDto findById(Long id) throws RuntimeException;

}
