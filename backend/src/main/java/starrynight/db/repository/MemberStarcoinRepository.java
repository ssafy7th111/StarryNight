package starrynight.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import starrynight.db.entity.MemberStarcoin;

public interface MemberStarcoinRepository extends JpaRepository<MemberStarcoin, Long> {
}
