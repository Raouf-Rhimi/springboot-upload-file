package bridge.nosql.workshop.service.impl;

import bridge.nosql.workshop.dto.StudentDTO;
import bridge.nosql.workshop.mapper.StudentMapper;
import bridge.nosql.workshop.repository.StudentRepository;
import bridge.nosql.workshop.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(
            StudentMapper studentMapper,
            StudentRepository studentRepository) {
        this.studentMapper = studentMapper;
        this.studentRepository = studentRepository;
    }

    @Override
    public Flux<StudentDTO> getAllStudents() {
        return studentRepository.findAll().map(studentMapper::toDto);
    }

    @Override
    public Mono<StudentDTO> saveStudent(StudentDTO studentDTO) {
        this.studentRepository.save(this.studentMapper.toEntity(studentDTO));
        return Mono.just(studentDTO);
    }
}
