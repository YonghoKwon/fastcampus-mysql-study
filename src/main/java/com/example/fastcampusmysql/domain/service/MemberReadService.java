package com.example.fastcampusmysql.domain.service;

import com.example.fastcampusmysql.domain.entity.Member;
import com.example.fastcampusmysql.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberReadService {
    private final MemberRepository memberRepository;

    public Member getMember(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow();
    }

}
