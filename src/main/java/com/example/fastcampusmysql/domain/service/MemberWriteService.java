package com.example.fastcampusmysql.domain.service;

import com.example.fastcampusmysql.domain.RegisterMemberCommand;
import com.example.fastcampusmysql.domain.entity.Member;
import com.example.fastcampusmysql.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberWriteService {
    private final MemberRepository memberRepository;

    public Member register(RegisterMemberCommand command) {
        var member = Member.builder()
                .email(command.email())
                .nickname(command.nickname())
                .birthday(command.birthday())
                .build();
        System.out.println("command : " + command);
        System.out.println("member : " + member);

        return memberRepository.save(member);
    }

    public void changeNickname(Long memberId, String nickname) {
        var member = memberRepository.findById(memberId).orElseThrow();
        member.changeNickname(nickname);
        memberRepository.save(member);
    }
}
