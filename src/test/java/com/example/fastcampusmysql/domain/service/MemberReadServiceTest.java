package com.example.fastcampusmysql.domain.service;

import com.example.fastcampusmysql.domain.entity.Member;
import com.example.fastcampusmysql.domain.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberReadServiceTest {
    @Autowired
    private MemberReadService service;

    @Autowired
    private MemberRepository memberRepository;

    @DisplayName("회원 조회 테스트")
    @Test
    public void testGetMember() {
        var member = Member.builder()
                .nickname("chairman")
                .email("pnu@fastcmapus.com")
                .birthday(LocalDate.now())
                .build();
        var id = memberRepository.save(member).getId();

        var result = service.getMember(id);

        Assertions.assertEquals(id, result.getId());
    }

    @DisplayName("회원 조회 실패")
    @Test
    public void testNotFound() {
        Assertions.assertThrows(
                NoSuchElementException.class,
                () -> service.getMember(-1L)
        );
    }

}