package uz.jurayev.academy.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import uz.jurayev.academy.domain.Tutor;
import uz.jurayev.academy.rest.TutorDto;

import java.util.List;

@Mapper()
public interface TutorMapper {

    TutorMapper INSTANCE = Mappers.getMapper(TutorMapper.class);

    TutorDto toTutorDto(Tutor tutor);
    List<TutorDto> toTutorDtos(List<Tutor> tutors);
    Tutor toTutor(TutorDto tutorDto);

}
