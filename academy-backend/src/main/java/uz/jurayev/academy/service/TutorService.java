package uz.jurayev.academy.service;

import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.TutorDto;
import java.util.List;

public interface TutorService {

    Result create(TutorDto tutorDto);
    Result delete(Long id);
    List<TutorDto> findAll();
    TutorDto findById(Long id);
    Result update(Long id, TutorDto tutorDto);
}
