package starrynight.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import starrynight.db.entity.Story;


public interface StoryRepository extends JpaRepository<Story, Long> {
}
