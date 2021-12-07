package uz.jurayev.academy.service;

import uz.jurayev.academy.domain.Region;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.RegionDto;
import java.util.List;

public interface RegionService {

    Result addRegion(RegionDto regionDto);

    List<Region> getAll(int page, int size);

    Region getOne(Integer id);

    Region edit(Integer id, RegionDto regionDto);

    boolean delete(Integer id);
}
