package starrynight.db.entity;

import org.hibernate.annotations.DynamicUpdate;
import starrynight.enums.Check;

import javax.persistence.*;
@DynamicUpdate
@Entity
@Table(
        name = "member_story"
)
public class MemberStory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="member_story_id")
    private Long id;    //식별자

    @Enumerated(EnumType.STRING)
    @Column(name ="isClear")
    private Check isClear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "story_id")
    private Story story;
}
