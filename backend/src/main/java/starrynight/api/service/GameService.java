package starrynight.api.service;

import org.springframework.stereotype.Service;
import starrynight.api.dto.game.StarcoinCountResponse;
import starrynight.db.entity.Member;
import starrynight.db.entity.MemberStarcoin;
import starrynight.db.entity.Starcoin;
import starrynight.db.repository.*;
import starrynight.exception.CustomException;
import starrynight.exception.CustomExceptionList;

import javax.transaction.Transactional;
import java.sql.SQLOutput;

@Service
@Transactional
public class GameService {
    final MemberRepository memberRepository;
    final StarcoinRepository starcoinRepository;
    final MemberStarcoinRepository memberStarcoinRepository;
    final StoryRepository storyRepository;
    final MemberStoryRepository memberStoryRepository;

    public GameService(MemberRepository memberRepository, StarcoinRepository starcoinRepository, MemberStarcoinRepository memberStarcoinRepository,
                       StoryRepository storyRepository, MemberStoryRepository memberStoryRepository) {
        this.memberRepository = memberRepository;
        this.memberStarcoinRepository = memberStarcoinRepository;
        this.memberStoryRepository = memberStoryRepository;
        this.storyRepository = storyRepository;
        this.starcoinRepository = starcoinRepository;
    }

    public Long getStarcoinCount(String address){
        Member member = memberRepository.findByEmail(address).orElseThrow(() ->
            new CustomException(CustomExceptionList.MEMBER_NOT_FOUND));
        return member.getStarcoin_count();
    }
}
