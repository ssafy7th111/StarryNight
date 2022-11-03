package starrynight.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import starrynight.db.entity.MemberRoomInfo;

public interface MemberRoomInfoRepository extends JpaRepository<MemberRoomInfo, Long> {
}
