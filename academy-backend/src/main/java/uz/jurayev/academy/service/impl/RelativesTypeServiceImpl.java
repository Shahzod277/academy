package uz.jurayev.academy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.jurayev.academy.domain.RelativesType;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.repository.RelativesTypeRepository;
import uz.jurayev.academy.service.RelativesTypeService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RelativesTypeServiceImpl implements RelativesTypeService {
    public final RelativesTypeRepository relativesTypeRepository;

    @Override
    public Result addRelativesType(RelativesType relativesType) {
        try {
            RelativesType type = new RelativesType();
            if (relativesType.getName().isEmpty()) {
                type.setName(relativesType.getName());
                relativesTypeRepository.save(type);
                return new Result("relativestype added", true);
            }
        } catch (Exception e) {
            return new Result("" + e.getMessage() + "", false);
        }
        return null;
    }

    @Override
    public List<RelativesType> getAll() {
        return relativesTypeRepository.findAll();
    }

    @Override
    public RelativesType getOne(Long id) {
        try {
            Optional<RelativesType> optionalRelativesType = relativesTypeRepository.findById(id);
            return optionalRelativesType.get();
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    @Override
    public Result edit(Long id, RelativesType relativesType) {
        Optional<RelativesType> optionalRelativesType = relativesTypeRepository.findById(id);
        if (optionalRelativesType.isEmpty()) {
            return new Result("id not found " + id + "", false);
        }
        RelativesType type = optionalRelativesType.get();
        type.setName(relativesType.getName());
        relativesTypeRepository.save(type);
        return new Result("succesfull edited", true);
    }

    @Override
    public Result delete(Long id) {
        try {
            relativesTypeRepository.deleteById(id);
            return new Result("deleted ", true);
        } catch (Exception e) {
            return new Result(e.getMessage() + "", false);
        }

    }
}
