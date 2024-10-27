package bridge.nosql.workshop.repository;

import bridge.nosql.workshop.model.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRepository extends JpaRepository<Membership, Long> {
}
