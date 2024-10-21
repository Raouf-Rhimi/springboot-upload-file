package bridge.nosql.workshop.service.impl;

import bridge.nosql.workshop.model.File;
import bridge.nosql.workshop.repository.FileRepository;
import bridge.nosql.workshop.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Optional;

@Service
public class FileServiceImpl implements FileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileServiceImpl.class.getName());
    private final FileRepository fileRepository;

    @Autowired
    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public Mono<ResponseEntity<?>> uploadFile(MultipartFile fileToBeUploaded) {
        try {
            if(!this.fileExists(fileToBeUploaded.getOriginalFilename())) {
                File file = new File();
                file.setFilename(fileToBeUploaded.getOriginalFilename());
                file.setContentType(fileToBeUploaded.getContentType());
                file.setSize(fileToBeUploaded.getSize());
                file.setData(fileToBeUploaded.getBytes());
                return Mono.just(new ResponseEntity<>( "File Uploaded Successfully "+this.fileRepository.save(file).block().getFilename(), HttpStatus.CREATED));
            }else {
                return Mono.just(new ResponseEntity<>("File already exists", HttpStatus.CONFLICT));
            }
        }catch (IOException e) {
            return Mono.just(new ResponseEntity<>("Error when getting Date from file",HttpStatus.BAD_REQUEST));
        }
    }

    @Override
    public Mono<ResponseEntity<?>> downloadFile(String filename) {
        Mono<Optional<File>> optionalFile = this.fileRepository.findFileByFilename(filename);
        if(optionalFile.block().isPresent()) {
            File file = optionalFile.block().get();
            return Mono.just(new ResponseEntity<>(file, HttpStatus.OK));
        }else {
            return Mono.just(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }
    }

    private boolean fileExists(String filename) {
        return fileRepository.existsByFilename(filename).block().booleanValue();
    }
}
