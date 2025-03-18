package lk.zerocode.learn_spring_boot.book_borrowing.controller;

import lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.requestDto.BookRequestDto;
import lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.responseDto.BookLIstResponse;
import lk.zerocode.learn_spring_boot.book_borrowing.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(value = "/books")
    public void create(@RequestBody BookRequestDto bookRequestDto) throws RuntimeException{
        bookService.create(bookRequestDto);
    }

    @GetMapping(value = "/books")
    public BookLIstResponse getAll(){
       return new BookLIstResponse( bookService.findAll() );
    }
}
