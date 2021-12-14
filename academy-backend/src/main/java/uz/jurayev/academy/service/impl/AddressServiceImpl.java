package uz.jurayev.academy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.jurayev.academy.domain.Address;
import uz.jurayev.academy.domain.Country;
import uz.jurayev.academy.domain.District;
import uz.jurayev.academy.domain.Region;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.AddressDTO;
import uz.jurayev.academy.repository.AddressRepository;
import uz.jurayev.academy.repository.DistrictRepository;
import uz.jurayev.academy.repository.RegionRepository;
import uz.jurayev.academy.service.AddressService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    final private AddressRepository addressRepository;
    final private DistrictRepository districtRepository;

    @Override
    public Result addAddress(AddressDTO addressDTO) {
        try {
            Optional<District> optionalDistrict = districtRepository.findById(addressDTO.getDistrictId());
                Address address = new Address();
                address.setDetails(addressDTO.getDetails());
                address.setDistrict(optionalDistrict.get());
                addressRepository.save(address);
                return new Result("Saved", true);
        } catch (Exception e) {
            return new Result("Xato!", false);
        }
    }

    @Override
    public List<Address> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Address> addresses = addressRepository.findAll(pageable);
        return addresses.getContent();
    }

    @Override
    public Address getOne(Long id) {
        Optional<Address> byId = addressRepository.findById(id);
        return byId.orElse(null);
    }

    @Override
    public boolean delete(Long id) {
        try {
            addressRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Address edit(Long id, AddressDTO addressDTO) {
        Optional<District> optionalDistrict = districtRepository.findById(addressDTO.getDistrictId());
        Optional<Address> byId = addressRepository.findById(id);

        if (byId.isPresent()) {
            if (optionalDistrict.isPresent()) {
                Address address = byId.get();
                address.setDetails(addressDTO.getDetails());
                address.setDistrict(optionalDistrict.get());
                return addressRepository.save(address);
            }
        }
        return null;
    }
}
