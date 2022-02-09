package uz.jurayev.academy.service;

import uz.jurayev.academy.domain.Region;
import uz.jurayev.academy.domain.University;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.RegionDto;
import uz.jurayev.academy.rest.UniversityDto;

import java.util.List;

public interface UniversityService {
    Result save(UniversityDto universityDto);

    List<University> getAll();

    University getOne(Integer id);

    Result update(Integer id, UniversityDto universityDto);

    Result delete(Integer id);
}
