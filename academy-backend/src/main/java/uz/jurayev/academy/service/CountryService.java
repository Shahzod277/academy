package uz.jurayev.academy.service;

import uz.jurayev.academy.domain.Country;
import uz.jurayev.academy.model.Result;
import java.util.List;

public interface CountryService {

    Result addCountry(Country country);
    List<Country> getAll(int page, int size);
    Country getOne(Integer id);
    Country edit(Integer id, Country country);
    boolean delete(Integer id);

}
