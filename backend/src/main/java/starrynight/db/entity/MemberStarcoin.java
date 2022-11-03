package starrynight.db.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import starrynight.enums.Check;

import javax.persistence.*;

@DynamicUpdate
@Entity
@Getter
@Setter
@Table(
        name = "member_starcoin"
)
public class MemberStarcoin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="member_starcoin_id")
    private Long id;    //식별자

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "starcoin_id")
    private Starcoin starcoin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Enumerated(EnumType.STRING)
    @Column(name ="isTaken")
    private Check isTaken;
}
