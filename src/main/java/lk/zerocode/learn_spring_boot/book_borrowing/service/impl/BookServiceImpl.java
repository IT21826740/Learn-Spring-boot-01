package lk.zerocode.learn_spring_boot.book_borrowing.service.impl;

import lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.requestDto.BookRequestDto;
import lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.responseDto.AuthorResponse;
import lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.responseDto.AuthorResponseDto;
import lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.responseDto.BookResponseDto;
import lk.zerocode.learn_spring_boot.book_borrowing.model.Author;
import lk.zerocode.learn_spring_boot.book_borrowing.model.Book;
import lk.zerocode.learn_spring_boot.book_borrowing.repository.AuthorRepository;
import lk.zerocode.learn_spring_boot.book_borrowing.repository.BookRepository;
import lk.zerocode.learn_spring_boot.book_borrowing.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void create(BookRequestDto bookRequestDto) throws RuntimeException {
        Book book = new Book();
        book.setTitle(bookRequestDto.getTitle());

        Optional<Author> author = authorRepository.findById(bookRequestDto.getAuthor());
        if (author.isPresent()) {
            book.setAuthor(author.get());
        } else {
            throw new RuntimeException("Author not found " + bookRequestDto.getAuthor());
        }

        bookRepository.save(book);
    }

    @Override
    public List<BookResponseDto> findAll() {
        List<Book> bookList = bookRepository.findAll();
        List<BookResponseDto> bookResponseDtoList = new ArrayList<>();

        for (Book book : bookList) {
            BookResponseDto responseDto = new BookResponseDto();
            responseDto.setId(book.getId());
            responseDto.setTitle(book.getTitle());

            if (book.getAuthor() != null) {
                responseDto.setAuthor(new AuthorResponseDto(
                        book.getAuthor().getId(),
                        book.getAuthor().getName()
                ));
            }

            bookResponseDtoList.add(responseDto);
        }
        return bookResponseDtoList;
    }
}
