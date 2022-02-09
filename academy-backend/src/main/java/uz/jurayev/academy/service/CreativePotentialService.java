package uz.jurayev.academy.service;

import org.springframework.data.domain.Page;
import uz.jurayev.academy.domain.CreativePotential;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.CreativePotentialDto;

public interface CreativePotentialService {

    Result save(CreativePotentialDto creativePotentialDto);

    Result update(Integer id, CreativePotentialDto creativePotentialDto);

    Page<CreativePotential> findAll(int page, int size);

    CreativePotential getOne(Integer id);

    Result delete(Integer id);

}
