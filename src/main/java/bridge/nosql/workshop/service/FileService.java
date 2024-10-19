package bridge.nosql.workshop.service;

import bridge.nosql.workshop.model.File;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface FileService {

    ResponseEntity<?> uploadFile(MultipartFile file);
    ResponseEntity<?> downloadFile(String filename);
}
