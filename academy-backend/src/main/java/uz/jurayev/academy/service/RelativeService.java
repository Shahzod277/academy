package uz.jurayev.academy.service;

import uz.jurayev.academy.domain.Education;
import uz.jurayev.academy.domain.Relative;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.EducationDto;
import uz.jurayev.academy.rest.RelativeDto;

import java.util.List;

public interface RelativeService {
    Result addRelative(RelativeDto relativeDto);

    List<Relative> getAll();

    Relative getOne(Long id);

    Result edit(Long id, RelativeDto relativeDto);

    Result delete(Long id);


}
