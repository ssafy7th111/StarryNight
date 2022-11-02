package starrynight.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import starrynight.db.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
