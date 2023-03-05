package com.example.fastcampusmysql.domain.controller;

import com.example.fastcampusmysql.domain.RegisterMemberCommand;
import com.example.fastcampusmysql.domain.entity.Member;
import com.example.fastcampusmysql.domain.service.MemberReadService;
import com.example.fastcampusmysql.domain.service.MemberWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MemberController {
    final private MemberWriteService memberWriteService;
    final private MemberReadService memberReadService;

    @PostMapping("/members")
    public Member register(@RequestBody RegisterMemberCommand command) {
        return memberWriteService.register(command);
    }

    @GetMapping("/members/{id}")
    public Member getMember(@PathVariable Long id) {
        return memberReadService.getMember(id);
    }
}
