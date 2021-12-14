package uz.jurayev.academy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.jurayev.academy.domain.Address;
import uz.jurayev.academy.domain.Country;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.repository.AddressRepository;
import uz.jurayev.academy.repository.CountryRepository;
import uz.jurayev.academy.rest.AddressDTO;
import uz.jurayev.academy.service.AddressService;
import uz.jurayev.academy.service.CountryService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    final private CountryRepository countryRepository;

    @Override
    public Result addCountry(Country country) {
        if (!countryRepository.existsByCountryName(country.getCountryName())) {
            Country countryAdd = new Country();
            countryAdd.setCountryName(country.getCountryName());
            countryRepository.save(countryAdd);
            return new Result("Saved!", true);
        }
        return new Result("Bunday Country bor!", false);
    }

    @Override
    public List<Country> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Country> countries = countryRepository.findAll(pageable);
        return countries.getContent();
    }

    @Override
    public Country getOne(Long id) {
        Optional<Country> byId = countryRepository.findById(id);
        return byId.orElse(null);
    }

    @Override
    public Country edit(Long id, Country country) {
        Optional<Country> byId = countryRepository.findById(id);
        if (byId.isPresent()){
            Country countryEdit = byId.get();
            countryEdit.setCountryName(country.getCountryName());
            return countryRepository.save(countryEdit);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        try {
            countryRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

