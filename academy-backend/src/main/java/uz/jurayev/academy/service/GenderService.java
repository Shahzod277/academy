package uz.jurayev.academy.service;

import org.springframework.data.domain.Page;
import uz.jurayev.academy.domain.Gender;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.GenderDto;

public interface GenderService {

    Result save(GenderDto genderDto);

    Result update(Long id,GenderDto genderDto);

    Page<Gender> findAll(int page, int size);

    Gender getOne(Long id);

    Result delete(Long id);

}
