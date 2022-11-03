package starrynight.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import starrynight.db.entity.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Boolean existsByEmail(String email);
    Optional<Member> findByEmail(String email);
}
