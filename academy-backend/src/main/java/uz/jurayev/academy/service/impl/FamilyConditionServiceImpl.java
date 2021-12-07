package uz.jurayev.academy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.jurayev.academy.domain.FamilyCondition;
import uz.jurayev.academy.domain.Invalid;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.repository.FamilyConditionRepository;
import uz.jurayev.academy.service.FamilyConditionService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FamilyConditionServiceImpl implements FamilyConditionService {

    final private FamilyConditionRepository familyConditionRepository;

    @Override
    public Result addCondition(FamilyCondition familyCondition) {
        if (!familyConditionRepository.existsByName(familyCondition.getName())) {
            FamilyCondition condition = new FamilyCondition();
            condition.setName(familyCondition.getName());
            familyConditionRepository.save(condition);
            return new Result("Saved", true);
        }
        return new Result("Bunday Condition bor", false);
    }

    @Override
    public List<FamilyCondition> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<FamilyCondition> conditions = familyConditionRepository.findAll(pageable);
        return conditions.getContent();
    }

    @Override
    public FamilyCondition getOne(Integer id) {
        Optional<FamilyCondition> byId = familyConditionRepository.findById(id);
        return byId.orElse(null);
    }

    @Override
    public FamilyCondition edit(Integer id, FamilyCondition condition) {
        Optional<FamilyCondition> byId = familyConditionRepository.findById(id);
        if (byId.isPresent()) {
            FamilyCondition familyCondition = new FamilyCondition();
            familyCondition.setName(condition.getName());
            return familyConditionRepository.save(familyCondition);
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        try {
            familyConditionRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
