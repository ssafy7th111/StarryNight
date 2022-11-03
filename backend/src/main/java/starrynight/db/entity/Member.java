package starrynight.db.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    private Long id;                //식별자
    private Date date;              //가입일자
    private Long starcoin_count;    //보유중인 스타코인 개수
    private String refresh_token;   //리프레쉬 토큰
    private String provider;        //소셜로그인 플랫폼
    private String email;           //소셜로그인 이메일
    private String nickname;        //닉네임

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


}
