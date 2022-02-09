package uz.jurayev.academy.service;

import uz.jurayev.academy.domain.District;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.DistrictDto;
import java.util.List;

public interface DistrictService {

    Result addDistrict(DistrictDto districtDto);

    List<District> getAll(int page, int size);

    District getOne(Integer id);

    Result edit(Integer id, DistrictDto districtDto);

    Result delete(Integer id);
}
