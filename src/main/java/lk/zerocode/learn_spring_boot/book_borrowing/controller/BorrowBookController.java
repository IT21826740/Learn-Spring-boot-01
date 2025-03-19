package lk.zerocode.learn_spring_boot.book_borrowing.controller;

import lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.requestDto.BorrowBookRequestDto;
import lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.responseDto.BorrowBookListResponse;
import lk.zerocode.learn_spring_boot.book_borrowing.service.BorrowBookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BorrowBookController {

private BorrowBookService borrowBookService;

 @PostMapping(value = "/borrow-books")
 public void create(@RequestBody BorrowBookRequestDto borrowBookRequestDto){
     borrowBookService.create(borrowBookRequestDto);
 }

 @GetMapping(value = "borrow-books")
 public BorrowBookListResponse getAll(){
    return new BorrowBookListResponse( borrowBookService.findAll());
 }
}
