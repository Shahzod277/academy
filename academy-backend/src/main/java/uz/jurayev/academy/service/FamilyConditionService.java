package uz.jurayev.academy.service;

import uz.jurayev.academy.domain.FamilyCondition;
import uz.jurayev.academy.model.Result;

import java.util.List;

public interface FamilyConditionService {

    Result addCondition(FamilyCondition familyCondition);

    List<FamilyCondition> getAll(int page, int size);

    FamilyCondition getOne(Long id);

    FamilyCondition edit(Long id, FamilyCondition condition);

    Result delete(Long id);

}
