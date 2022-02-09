package uz.jurayev.academy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.jurayev.academy.domain.Nationality;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.repository.NationalityRepository;
import uz.jurayev.academy.service.NationalityService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NationalityServiceImpl implements NationalityService {
    private final NationalityRepository nationalityRepository;

    @Override
    public Result save(Nationality nationality) {
        try {
            Nationality saveNationality = new Nationality();
            saveNationality.setNationalityName(nationality.getNationalityName());
            nationalityRepository.save(saveNationality);
            return new Result("saved Successfull", true);
        } catch (Exception e) {
            return new Result(e.getMessage() + "", false);
        }
    }

    @Override
    public List<Nationality> getAll() {
        return nationalityRepository.findAll();
    }

    @Override
    public Nationality getOne(Integer id) {
        Optional<Nationality> byId = nationalityRepository.findById(id);
        if (byId.isEmpty()) {
            return new Nationality();
        }
        return byId.get();
    }

    @Override
    public Result update(Integer id, Nationality nationality) {
        Optional<Nationality> byId = nationalityRepository.findById(id);
        if (byId.isPresent()) {
            Nationality nationality1 = byId.get();
            nationality1.setNationalityName(nationality.getNationalityName());
            nationalityRepository.save(nationality1);
            return new Result("updated successfull", true);
        }
        return new Result("id not found ", false);
    }

    @Override
    public Result delete(Integer id) {
        try {
            nationalityRepository.deleteById(id);
            return new Result("deleted", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result("id not found ", false);
    }
}
