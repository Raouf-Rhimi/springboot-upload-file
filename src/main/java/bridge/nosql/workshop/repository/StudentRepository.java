package bridge.nosql.workshop.repository;

import bridge.nosql.workshop.model.Student;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface StudentRepository  extends ReactiveMongoRepository<Student, String> {
}
