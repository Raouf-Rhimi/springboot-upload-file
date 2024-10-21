package bridge.nosql.workshop.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

public interface FileService {

    Mono<ResponseEntity<?>> uploadFile(MultipartFile file);
    Mono<ResponseEntity<?>> downloadFile(String filename);
}
