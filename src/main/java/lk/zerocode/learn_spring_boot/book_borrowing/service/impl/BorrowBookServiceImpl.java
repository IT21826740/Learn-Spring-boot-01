package lk.zerocode.learn_spring_boot.book_borrowing.service.impl;

import lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.requestDto.BorrowBookRequestDto;
import lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.responseDto.BorrowBookResponseDto;
import lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.responseDto.BorrowedBookResponseDto;
import lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.responseDto.MemberResponseDto;
import lk.zerocode.learn_spring_boot.book_borrowing.model.Book;
import lk.zerocode.learn_spring_boot.book_borrowing.model.BorrowBook;
import lk.zerocode.learn_spring_boot.book_borrowing.model.Member;
import lk.zerocode.learn_spring_boot.book_borrowing.repository.BookRepository;
import lk.zerocode.learn_spring_boot.book_borrowing.repository.BorrowBookRepository;
import lk.zerocode.learn_spring_boot.book_borrowing.repository.MemberRepository;
import lk.zerocode.learn_spring_boot.book_borrowing.service.BorrowBookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BorrowBookServiceImpl implements BorrowBookService {

    private BorrowBookRepository borrowBookRepository;
    private BookRepository bookRepository;
    private MemberRepository memberRepository;

    @Override
    public void create(BorrowBookRequestDto borrowBookRequestDto) {
        BorrowBook borrowBook = new BorrowBook();

        Book book = bookRepository.findById(borrowBookRequestDto.getBook()).orElseThrow(() -> new RuntimeException("Book not found"));
        Member member = memberRepository.findById(borrowBookRequestDto.getMember()).orElseThrow(() -> new RuntimeException("Member not found"));

        borrowBook.setBook(book);
        borrowBook.setMember(member);
        borrowBook.setBorrowDate(LocalDate.now());
        borrowBookRepository.save(borrowBook);
    }

    @Override
    public List<BorrowBookResponseDto> findAll() {
        List<BorrowBook> borrowBookList = borrowBookRepository.findAll();
        List<BorrowBookResponseDto> borrowBookResponseDtoList = new ArrayList<>();

        for (BorrowBook borrowBook : borrowBookList) {
            BorrowBookResponseDto responseDto = new BorrowBookResponseDto();
            responseDto.setId(borrowBook.getId());

            if (borrowBook.getBook() != null) {
                responseDto.setBook(new BorrowedBookResponseDto(
                        borrowBook.getBook().getId(),
                        borrowBook.getBook().getTitle()
                ));
            }

            if (borrowBook.getMember() != null) {
                responseDto.setMember(new MemberResponseDto(
                        borrowBook.getMember().getId(),
                        borrowBook.getMember().getName()
                ));
            }

            responseDto.setBorrowDate(borrowBook.getBorrowDate());

            borrowBookResponseDtoList.add(responseDto);
        }
        return borrowBookResponseDtoList;
    }

}
