package uz.jurayev.academy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.jurayev.academy.domain.Country;
import uz.jurayev.academy.domain.District;
import uz.jurayev.academy.domain.Region;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.repository.CountryRepository;
import uz.jurayev.academy.repository.RegionRepository;
import uz.jurayev.academy.rest.RegionDto;
import uz.jurayev.academy.service.RegionService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {


    private final RegionRepository regionRepository;
    private final CountryRepository countryRepository;

    @Override
    public Result addRegion(RegionDto regionDto) {
        Optional<Country> countryOptional = countryRepository.findById(regionDto.getCountryId());

        if (!regionRepository.existsByRegionName(regionDto.getName())) {
            Region region = new Region();
            region.setRegionName(regionDto.getName());
            region.setCountry(countryOptional.get());
            regionRepository.save(region);
            return new Result("Saved!", true);
        }
        return new Result("Bunday Region bor!", false);
    }

    @Override
    public List<Region> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Region> regions = regionRepository.findAll(pageable);
        return regions.getContent();
    }

    @Override
    public Region getOne(Integer id) {
        Optional<Region> byId = regionRepository.findById(id);
        return byId.orElse(null);
    }

    @Override
    public boolean delete(Integer id) {
        try {
            regionRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Region edit(Integer id, RegionDto regionDto) {
        Optional<Country> countryOptional = countryRepository.findById(regionDto.getCountryId());
        Optional<Region> byId = regionRepository.findById(id);
        if (byId.isPresent()){
            Region region = byId.get();
            region.setRegionName(regionDto.getName());
            region.setCountry(countryOptional.get());
            return regionRepository.save(region);
        }
        return null;
    }
}
