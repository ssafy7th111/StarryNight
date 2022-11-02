package starrynight.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import starrynight.db.entity.Starcoin;

public interface StarcoinRepository extends JpaRepository<Starcoin, Long> {
}
