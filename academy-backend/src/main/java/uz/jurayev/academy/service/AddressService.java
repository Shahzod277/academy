package uz.jurayev.academy.service;

import uz.jurayev.academy.domain.Address;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.AddressDTO;

import java.util.List;

public interface AddressService {
    Result addAddress(AddressDTO addressDTO);

    List<Address> getAll(int page, int size);

    Address getOne(Integer id);

    boolean delete(Integer id);

    Address edit(Integer id, AddressDTO addressDTO);
}
