package uz.jurayev.academy.service;

import uz.jurayev.academy.domain.FamilyStatus;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.FamilyStatusDTO;

import java.util.List;

public interface FamilyStatusService {


    Result Add(FamilyStatusDTO familyStatusDTO);

    List<FamilyStatus> getAll(int page, int size);

    FamilyStatus getOne(Integer id);

    FamilyStatus edit(Integer id, FamilyStatusDTO familyStatusDTO);

    boolean delete(Integer id);
}
