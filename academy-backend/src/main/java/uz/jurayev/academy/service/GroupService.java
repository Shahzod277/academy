package uz.jurayev.academy.service;

import uz.jurayev.academy.domain.Groups;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.GroupsDto;

import java.util.List;

public interface GroupService {
    Result addGroup(GroupsDto groupsDto);
    List<Groups> getAll();
    Groups getOne(Long id);
    Result edit(Long id, GroupsDto groupsDto);
    Result delete(Long id);
}
