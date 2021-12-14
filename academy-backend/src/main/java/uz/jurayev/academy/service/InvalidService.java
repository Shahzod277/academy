package uz.jurayev.academy.service;

import uz.jurayev.academy.domain.Invalid;
import uz.jurayev.academy.model.Result;

import java.util.List;

public interface InvalidService {
    Result invalidAdd(Invalid invalid);

    List<Invalid> getAll(int page, int size);

    Invalid getOne(Long id);

    Invalid edit(Long id, Invalid invalid);

    Result delete(Long id);

}
