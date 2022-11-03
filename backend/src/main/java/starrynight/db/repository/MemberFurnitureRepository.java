package starrynight.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import starrynight.db.entity.MemberFurniture;

public interface MemberFurnitureRepository extends JpaRepository<MemberFurniture, Long> {
}
