package starrynight.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import starrynight.db.entity.Furniture;

public interface FurnitureRepository extends JpaRepository<Furniture, Long> {
}
