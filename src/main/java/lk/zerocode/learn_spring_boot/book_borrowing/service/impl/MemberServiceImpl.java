package lk.zerocode.learn_spring_boot.book_borrowing.service.impl;

import lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.requestDto.MemberRequestDto;
import lk.zerocode.learn_spring_boot.book_borrowing.controller.dto.responseDto.MemberResponseDto;
import lk.zerocode.learn_spring_boot.book_borrowing.model.Member;
import lk.zerocode.learn_spring_boot.book_borrowing.repository.MemberRepository;
import lk.zerocode.learn_spring_boot.book_borrowing.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public void create(MemberRequestDto memberRequestDto) {
           Member member = new Member();
           member.setName(memberRequestDto.getName());
           memberRepository.save(member);

    }

    @Override
    public List<MemberResponseDto> findAll() {
        List<Member> members = memberRepository.findAll();
        List<MemberResponseDto> memberResponseList = new ArrayList<>();

        for (Member member : members) {
           MemberResponseDto responseDto = new MemberResponseDto(member.getId(), member.getName());
           memberResponseList.add(responseDto);
        }
        return memberResponseList;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete(Long id) throws Exception {
     Member member = memberRepository.findById(id).orElseThrow(
             ()-> new Exception("Member not found with " +id+"  ! ")
     );
     memberRepository.delete(member);
    }

    @Override
    public MemberResponseDto findById(Long id) throws RuntimeException{
       Optional< Member> member = memberRepository.findById(id);
       if (member.isPresent()){
           return new MemberResponseDto(member.get().getId(), member.get().getName());
       }else{
            throw new RuntimeException("Member not found");
       }
    }
}
