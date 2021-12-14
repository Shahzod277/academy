package uz.jurayev.academy.service;


import uz.jurayev.academy.domain.Country;
import uz.jurayev.academy.model.Result;
import java.util.List;

public interface CountryService {

    Result addCountry(Country country);
    List<Country> getAll(int page, int size);
    Country getOne(Long id);
    Country edit(Long id, Country country);
    boolean delete(Long id);

}
