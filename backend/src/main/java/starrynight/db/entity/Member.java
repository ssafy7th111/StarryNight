package starrynight.db.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
@Entity
@Getter
@Setter
@Table(
        name = "member"
)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="member_id")
    private Long id;               //식별자
    private Date createDate;       //가입일자
    private Long starcoinCount;    //보유중인 스타코인 개수
    private String refreshToken;   //리프레쉬 토큰
    private String provider;       //소셜로그인 플랫폼
    private String email;           //소셜로그인 이메일
    private String name;            // 소셜로그인 이름
    private String nickname;       // 닉네임
    private String isDeleted;       // 탈퇴 여부

    @OneToMany(
            mappedBy = "member",
            cascade = {CascadeType.ALL}
    )
    private List<MemberStarcoin> memberStarcoins = new ArrayList();

    @OneToMany(
            mappedBy = "member",
            cascade = {CascadeType.ALL}
    )
    private List<MemberStory> memberStories = new ArrayList();

    @OneToMany(
            mappedBy = "member",
            cascade = {CascadeType.ALL}
    )
    private List<MemberFurniture> memberFurnitures = new ArrayList();


    @OneToOne(mappedBy = "member", fetch = FetchType.LAZY)
    private MemberRoom memberRoom;

    @Builder
    public Member(String name, String email, String provider, String nickname)
    {
        this.name = name;
        this.email = email;
        this.provider = provider;
        this.nickname = nickname;
    }

    //임시로 사용(카카오 로그인 만들어지면 삭제할 것)
    public Member(String nickname){
        this.nickname = nickname;
        this.starcoinCount = (long) 0;
    }

    public Member update(String name, String email) {
        this.name = name;
        this.email = email;

        return this;
    }
}
