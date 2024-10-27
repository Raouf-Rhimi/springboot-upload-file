package bridge.nosql.workshop.repository;

import bridge.nosql.workshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

