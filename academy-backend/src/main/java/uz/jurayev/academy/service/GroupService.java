package uz.jurayev.academy.service;

import uz.jurayev.academy.domain.Group;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.GroupDto;
import java.util.List;

public interface GroupService {
    Result save(GroupDto groupsDto);

    List<Group> getAll(int page, int size);

    Group getOne(Long id);

    Result edit(Long id, GroupDto groupDto);

    Result delete(Long id);
}
