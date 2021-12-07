package uz.jurayev.academy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.jurayev.academy.domain.Gender;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.repository.GenderRepository;
import uz.jurayev.academy.rest.GenderDto;
import uz.jurayev.academy.service.GenderService;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GenderServiceImpl implements GenderService {

    private final GenderRepository genderRepository;

    @Override
    public Result save(GenderDto genderDto) {
        Gender save = new Gender();
        save.setName(genderDto.getName());
        genderRepository.save(save);
        return new Result( "saved", true);
    }

    @Override
    public Result update(Long id, GenderDto genderDto) {
        Optional<Gender> optionalGender =
                genderRepository.findById(id);
        if (optionalGender.isEmpty())
            return new Result( "not found gender", false);
        Gender update = optionalGender.get();
        update.setName(genderDto.getName());
        return new Result("update gender",true);
    }

    @Override
    public Page<Gender> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Gender> all = genderRepository.findAll(pageable);
        return all;
    }

    @Override
    public Gender getOne(Long id) {
        Optional<Gender> genderOptional =
                genderRepository.findById(id);
        if (genderOptional.isEmpty())
            return null;
        return genderOptional.get();
    }

    @Override
    public Result delete(Long id) {
        try {
            genderRepository.deleteById(id);
            return new Result( "deleted", true);
        }catch (Exception e){
            return new Result( "error " + e.getMessage(), false);
        }
    }
}
