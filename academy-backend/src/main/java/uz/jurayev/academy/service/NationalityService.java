package uz.jurayev.academy.service;

import uz.jurayev.academy.domain.Nationality;
import uz.jurayev.academy.domain.Relative;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.RelativeDto;

import java.util.List;

public interface NationalityService {
    Result save(Nationality nationality);

    List<Nationality> getAll();

    Nationality getOne(Long id);

    Result update(Long id, Nationality nationality);

    Result delete(Long id);

}
