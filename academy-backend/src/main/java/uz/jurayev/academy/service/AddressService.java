package uz.jurayev.academy.service;

import uz.jurayev.academy.domain.Address;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.AddressDTO;

import java.util.List;

public interface AddressService {
    Result addAddress(AddressDTO addressDTO);

    List<Address> getAll(int page, int size);

    Address getOne(Long id);

    boolean delete(Long id);

    Address edit(Long id, AddressDTO addressDTO);
}
