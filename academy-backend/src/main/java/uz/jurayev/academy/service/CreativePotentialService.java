package uz.jurayev.academy.service;

import org.springframework.data.domain.Page;
import uz.jurayev.academy.domain.CreativePotential;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.CreativePotentialDto;

public interface CreativePotentialService {

    Result save(CreativePotentialDto creativePotentialDto);

    Result update(Long id, CreativePotentialDto creativePotentialDto);

    Page<CreativePotential> findAll(int page, int size);

    CreativePotential getOne(Long id);

    Result delete(Long id);

}
