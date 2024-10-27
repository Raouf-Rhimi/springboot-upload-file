package bridge.nosql.workshop.repository;

import bridge.nosql.workshop.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
