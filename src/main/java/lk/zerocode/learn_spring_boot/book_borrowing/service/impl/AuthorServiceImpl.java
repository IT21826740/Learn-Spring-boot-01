package lk.zerocode.learn_spring_boot.book_borrowing.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.requestDto.AuthorRequestDto;
import lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.responseDto.AuthorResponseDto;
import lk.zerocode.learn_spring_boot.book_borrowing.model.Author;
import lk.zerocode.learn_spring_boot.book_borrowing.repository.AuthorRepository;
import lk.zerocode.learn_spring_boot.book_borrowing.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void create(AuthorRequestDto authorRequestDto) {
        Author author = new Author();
        author.setName(authorRequestDto.getName());
        authorRepository.save(author);
    }

    @Override
    public List<AuthorResponseDto> findAll() {
        List< Author> authorList = authorRepository.findAll();
         List<AuthorResponseDto> authorResponseDtoList = new ArrayList<>();

         for( Author author : authorList ){
             AuthorResponseDto authorResponseDto = new AuthorResponseDto();
             authorResponseDto.setId(author.getId());
             authorResponseDto.setName(author.getName());
             authorResponseDtoList.add(authorResponseDto);
         }
         return authorResponseDtoList;
    }

    @Override
    public AuthorResponseDto findById(Long id) {
       Author author = authorRepository.findById(id).orElseThrow(
               ()-> new EntityNotFoundException("Author not found with id: " + id)
       );
       AuthorResponseDto authorResponseDto = new AuthorResponseDto();
       authorResponseDto.setId(author.getId());
       authorResponseDto.setName(author.getName());

        return authorResponseDto;
    }

}
