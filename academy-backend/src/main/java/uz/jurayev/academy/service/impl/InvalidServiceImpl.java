package uz.jurayev.academy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.jurayev.academy.domain.Country;
import uz.jurayev.academy.domain.Invalid;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.repository.InvalidRepository;
import uz.jurayev.academy.service.InvalidService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvalidServiceImpl implements InvalidService {
    final private InvalidRepository invalidRepository;
    @Override
    public Result invalidAdd(Invalid invalid) {
        if (!invalidRepository.existsByName(invalid.getName())) {
            Invalid addInvalid = new Invalid();
            addInvalid.setName(invalid.getName());
            invalidRepository.save(addInvalid);
            return new Result("Saved!", true);
        }
        return new Result("Bunday Invalidlik turi bor!", false);
    }

    @Override
    public List<Invalid> getAll(int page, int size) {
        Pageable pageable= PageRequest.of(page,size);
        Page<Invalid> invalids = invalidRepository.findAll(pageable);
        return  invalids.getContent();
    }

    @Override
    public Invalid getOne(Long id) {
        Optional<Invalid> byId = invalidRepository.findById(id);
        return byId.orElse(null);
    }

    @Override
    public Invalid edit(Long id, Invalid invalid) {
        Optional<Invalid> byId = invalidRepository.findById(id);
        if (byId.isPresent()){
            Invalid invalidEdit = byId.get();
            invalidEdit.setName(invalid.getName());
            return invalidRepository.save(invalidEdit);
        }
        return null;
    }

    @Override
    public Result delete(Long id) {
        try {
            invalidRepository.deleteById(id);
            return new Result("deleted",true);
        }catch (Exception e){
            return new Result("Xato!",false);
        }
    }
}
