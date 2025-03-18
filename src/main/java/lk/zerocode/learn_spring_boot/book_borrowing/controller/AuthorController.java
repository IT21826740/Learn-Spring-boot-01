package lk.zerocode.learn_spring_boot.book_borrowing.controller;

import lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.requestDto.AuthorRequestDto;
import lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.responseDto.AuthorListResponse;
import lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.responseDto.AuthorResponse;
import lk.zerocode.learn_spring_boot.book_borrowing.model.Author;
import lk.zerocode.learn_spring_boot.book_borrowing.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping(value = "/authors")
    public void create(@RequestBody AuthorRequestDto authorRequestDto) {
        authorService.create(authorRequestDto);
    }

    @GetMapping(value = "/authors")
    public AuthorListResponse getAll(){
        return  new AuthorListResponse(authorService.findAll());

    }

    @GetMapping(value = "/authors/{author-id}")
    public AuthorResponse getById(@PathVariable("author-id") Long id){
        return  new AuthorResponse(authorService.findById(id));
    }
}
