package starrynight.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import starrynight.db.entity.MemberRoom;

public interface MemberRoomRepository extends JpaRepository<MemberRoom, Long> {
}
