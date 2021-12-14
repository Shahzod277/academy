package uz.jurayev.academy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.jurayev.academy.domain.District;
import uz.jurayev.academy.domain.Region;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.repository.DistrictRepository;
import uz.jurayev.academy.repository.RegionRepository;
import uz.jurayev.academy.rest.DistrictDto;
import uz.jurayev.academy.service.DistrictService;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class DistrictServiceImpl implements DistrictService {

    final private DistrictRepository districtRepository;
    final private RegionRepository regionRepository;

    @Override
    public Result addDistrict(DistrictDto districtDto) {
        Optional<Region> regionOptional = regionRepository.findById(districtDto.getRegionId());

        if (!districtRepository.existsByDistrictName(districtDto.getName())) {
            District districtAdd = new District();
            districtAdd.setDistrictName(districtDto.getName());
            districtAdd.setRegion(regionOptional.get());
            districtRepository.save(districtAdd);
            return new Result("Saved!", true);
        }
        return new Result("Bunday District bor!", false);
    }

    @Override
    public List<District> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<District> districts = districtRepository.findAll(pageable);
        return districts.getContent();
    }

    @Override
    public District getOne(Long id) {
        Optional<District> byId = districtRepository.findById(id);
        return byId.orElse(null);
    }

    @Override
    public District edit(Long id, DistrictDto districtDto) {
        Optional<Region> regionOptional = regionRepository.findById(districtDto.getRegionId());
        Optional<District> byId = districtRepository.findById(id);
        if (byId.isPresent()){
            District districtEdit = byId.get();
            districtEdit.setDistrictName(districtDto.getName());
            districtEdit.setRegion(regionOptional.get());
            return districtRepository.save(districtEdit);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        try {
            districtRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
