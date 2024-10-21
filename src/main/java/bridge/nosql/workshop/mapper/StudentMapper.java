package bridge.nosql.workshop.mapper;

import bridge.nosql.workshop.dto.StudentDTO;
import bridge.nosql.workshop.model.Student;
import org.mapstruct.Mapper;

@Mapper
public interface StudentMapper{

    StudentDTO toDto(Student student);
    Student toEntity(StudentDTO studentDTO);
}
