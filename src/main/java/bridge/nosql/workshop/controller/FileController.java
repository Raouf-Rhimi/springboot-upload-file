package bridge.nosql.workshop.controller;


import bridge.nosql.workshop.model.File;
import bridge.nosql.workshop.service.impl.FileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/file")
public class FileController {

    private final FileServiceImpl fileService;

    @Autowired
    public FileController(FileServiceImpl fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public Mono<ResponseEntity<?>> uploadFile(@RequestParam("file") MultipartFile fileToBeUploaded) {
       return this.fileService.uploadFile(fileToBeUploaded);

    }

    @GetMapping("/download/{filename}")
    public Mono<ResponseEntity<?>> downloadFile(@PathVariable String filename) {
        Mono<ResponseEntity<?>> response = this.fileService.downloadFile(filename);
        if (response.block().getStatusCode() == HttpStatus.OK) {
            File file = (File) response.block().getBody();
            return Mono.just(ResponseEntity.ok().contentType(MediaType.parseMediaType(file.getContentType()))
                    .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\""+file.getFilename()+"\"")
                    .body(file.getData()));
        }else{
            return Mono.just(new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND));
        }

    }
}
