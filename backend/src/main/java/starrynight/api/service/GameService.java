package starrynight.api.service;

import org.springframework.stereotype.Service;
import starrynight.db.entity.Member;
import starrynight.db.repository.MemberRepository;

import javax.transaction.Transactional;
import java.sql.SQLOutput;

@Service
@Transactional
public class GameService {
    final MemberRepository memberRepository;

    public GameService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long getStarcoinCount(String address){
        Member member = memberRepository.findById((long) 1).get();
        System.out.println("I FOUND IT");
        return member.getStarcoinCount();
    }
}
