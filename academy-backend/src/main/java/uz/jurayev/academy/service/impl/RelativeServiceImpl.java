package uz.jurayev.academy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.jurayev.academy.domain.*;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.repository.*;
import uz.jurayev.academy.rest.RelativeDto;
import uz.jurayev.academy.service.RelativeService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RelativeServiceImpl implements RelativeService {
    public final RelativeRepository relativeRepository;
    public final RelativesTypeRepository relativesTypeRepository;
    public final InvalidRepository invalidRepository;
    public final AddressRepository addressRepository;
    public final BenefitRepository benefitRepository;

    @Override
    public Result addRelative(RelativeDto relativeDto) {
        Relative relative = new Relative();
        if (!addressRepository.findById(relativeDto.getAddressId()).isPresent()) {
            return new Result("address id not found " + relativeDto.getAddressId() + "", false);
        }
        relative.setAddressId(relativeDto.getAddressId());
        if (invalidRepository.findById(relativeDto.getInvalidId()).isEmpty()) {
            return new Result("invalid id not found " + relativeDto.getInvalidId() + "", false);
        }
        relative.setInvalidId(relativeDto.getInvalidId());
        if (!benefitRepository.findById(relativeDto.getBenefitId()).isPresent()) {
            return new Result("benefit id not found " + relativeDto.getBenefitId() + "", false);
        }
        relative.setBenefitId(relativeDto.getBenefitId());
        if (relativesTypeRepository.findById(relativeDto.getRelativesTypeId()).isEmpty()) {
            return new Result("relativesType not found" + relativeDto.getRelativesTypeId() + "", false);
        }
        relative.setRelativesTypeId(relativeDto.getRelativesTypeId());
        relative.setLastname(relativeDto.getLastname());
        relative.setName(relativeDto.getName());
        relative.setSurname(relativeDto.getSurname());
        relative.setPhoneNumber(relativeDto.getPhoneNumber());
        relativeRepository.save(relative);
        return new Result("successfull added", true);
    }

    @Override
    public List<Relative> getAll() {
        List<Relative> all = relativeRepository.findAll();
        return all;
    }

    @Override
    public Relative getOne(Long id) {
        try {
            Optional<Relative> byId = relativeRepository.findById(id);
            return byId.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Result edit(Long id, RelativeDto relativeDto) {
        Optional<Relative> optionalRelative = relativeRepository.findById(id);
        if (optionalRelative.isEmpty()) {
            return new Result("relative id not found " + id + "", false);
        }
        Relative editRelative = optionalRelative.get();
        editRelative.setPhoneNumber(relativeDto.getPhoneNumber());
        editRelative.setName(relativeDto.getName());
        editRelative.setSurname(relativeDto.getSurname());
        editRelative.setLastname(relativeDto.getLastname());
        editRelative.setBenefitId(relativeDto.getBenefitId());
        editRelative.setInvalidId(relativeDto.getInvalidId());
        Optional<RelativesType> optionalRelativesType = relativesTypeRepository.findById(relativeDto.getRelativesTypeId());
        if (optionalRelativesType.isEmpty()) {
            return new Result("relativesType not found ", false);
        }
        editRelative.setRelativesTypeId(optionalRelativesType.get().getId());
        Optional<Address> optionalAddress = addressRepository.findById(relativeDto.getAddressId());
        if (optionalAddress.isEmpty()) {
            return new Result("address not found ",false);
        }
        editRelative.setAddressId(optionalAddress.get().getId());
        relativeRepository.save(editRelative);
        return new Result("relative edited",true);
    }


    @Override
    public Result delete(Long id) {
        boolean exists = relativeRepository.existsById(id);
        if (!exists) {
            return new Result("id not found ", false);
        }
        relativeRepository.deleteById(id);
        return new Result("deleted", true);
    }
}