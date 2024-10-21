package bridge.nosql.workshop.repository;

import bridge.nosql.workshop.model.File;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface FileRepository extends ReactiveMongoRepository<File, String> {
    Mono<Optional<File>> findFileByFilename(String filename);
    Mono<Boolean> existsByFilename(String filename);
}
