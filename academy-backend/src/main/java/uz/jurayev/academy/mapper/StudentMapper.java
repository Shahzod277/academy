package uz.jurayev.academy.mapper;

import org.mapstruct.Mapper;
import uz.jurayev.academy.domain.Student;
import uz.jurayev.academy.rest.StudentDto;
import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

   // StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDto toStudentDto(Student student);
    List<StudentDto> toStudentDtos(List<Student> students);
    Student toStudent(StudentDto studentDto);

}
