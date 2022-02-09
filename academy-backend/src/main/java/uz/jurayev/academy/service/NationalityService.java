package uz.jurayev.academy.service;

import uz.jurayev.academy.domain.Nationality;
import uz.jurayev.academy.model.Result;

import java.util.List;

public interface NationalityService {
    Result save(Nationality nationality);

    List<Nationality> getAll();

    Nationality getOne(Integer id);

    Result update(Integer id, Nationality nationality);

    Result delete(Integer id);

}
