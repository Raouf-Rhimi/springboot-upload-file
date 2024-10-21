package bridge.nosql.workshop.controller;


import bridge.nosql.workshop.dto.StudentDTO;
import bridge.nosql.workshop.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public Flux<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }
    @PostMapping()
    public Mono<StudentDTO> saveStudent(@RequestBody StudentDTO student) {
        return studentService.saveStudent(student);
    }
}
