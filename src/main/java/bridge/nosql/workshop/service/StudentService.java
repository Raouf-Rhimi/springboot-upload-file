package bridge.nosql.workshop.service;

import bridge.nosql.workshop.dto.StudentDTO;
import bridge.nosql.workshop.model.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentService {

    Flux<StudentDTO> getAllStudents();
    Mono<StudentDTO> saveStudent(StudentDTO studentDTO);
}
