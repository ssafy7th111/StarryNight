package starrynight.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import starrynight.db.entity.MemberStory;

public interface MemberStoryRepository extends JpaRepository<MemberStory, Long> {
}
