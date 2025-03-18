package lk.zerocode.learn_spring_boot.book_borrowing.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "member")
    private List<BorrowBook>  borrowBooks;
}
