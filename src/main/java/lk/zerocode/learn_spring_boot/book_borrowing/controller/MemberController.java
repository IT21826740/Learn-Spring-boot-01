package lk.zerocode.learn_spring_boot.book_borrowing.controller;

import lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.requestDto.MemberRequestDto;
import lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.responseDto.MemberListResponse;
import lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.responseDto.MemberResponse;
import lk.zerocode.learn_spring_boot.book_borrowing.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping(value = "/members")
    public String  create(@RequestBody MemberRequestDto memberRequestDto) {
        memberService.create(memberRequestDto);
        return "successfully created member";
    }

    @GetMapping("/members")
    public MemberListResponse getAllMembers() {
        return new MemberListResponse(memberService.findAll());
    }

    @GetMapping(value = "/members/{member-id}")
    public MemberResponse getMemberById(@PathVariable("member-id") Long id) throws RuntimeException {
       return new MemberResponse( memberService.findById(id));
    }

    @DeleteMapping(value = "members/{member-id}")
    public String deleteById(@PathVariable("member-id") Long id)throws  Exception{
        memberService.delete(id);
        return "successfully deleted member";
    }

}

