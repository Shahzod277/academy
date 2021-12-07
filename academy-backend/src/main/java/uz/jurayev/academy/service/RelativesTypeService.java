package uz.jurayev.academy.service;


import uz.jurayev.academy.domain.RelativesType;
import uz.jurayev.academy.model.Result;

import java.util.List;

public interface RelativesTypeService {
    Result addRelativesType(RelativesType relativesType);

    List<RelativesType> getAll();

    RelativesType getOne(Long id);

    Result edit(Long id, RelativesType relativesType);

    Result delete(Long id);
}
