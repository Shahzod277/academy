package uz.jurayev.academy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.jurayev.academy.domain.FamilyCondition;
import uz.jurayev.academy.domain.FamilyStatus;
import uz.jurayev.academy.domain.Invalid;
import uz.jurayev.academy.domain.LostBreadwinner;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.repository.FamilyConditionRepository;
import uz.jurayev.academy.repository.FamilyStatusRepository;
import uz.jurayev.academy.repository.InvalidRepository;
import uz.jurayev.academy.repository.LostBreadwinnerRepository;
import uz.jurayev.academy.rest.FamilyStatusDTO;
import uz.jurayev.academy.service.FamilyStatusService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FamilyStatusServiceImpl implements FamilyStatusService {

    final private FamilyStatusRepository familyStatusRepository;
    final private LostBreadwinnerRepository breadwinnerRepository;
    final private FamilyConditionRepository familyConditionRepository;
    final private InvalidRepository invalidRepository;

    @Override
    public Result Add(FamilyStatusDTO familyStatusDTO) {
        Optional<FamilyCondition> optionalFamilyCondition = familyConditionRepository.findById(familyStatusDTO.getFamilyConditionId());
        Optional<Invalid> optionalInvalid = invalidRepository.findById(familyStatusDTO.getInvalidId());
        Optional<LostBreadwinner> optionalLostBreadwinner = breadwinnerRepository.findById(familyStatusDTO.getLostBreadwinnerId());
            FamilyStatus familyStatusAdd = new FamilyStatus();
            familyStatusAdd.setFamilyConditionId(optionalFamilyCondition.get());
            familyStatusAdd.setInvalidId(optionalInvalid.get());
            familyStatusAdd.setLostBreadwinnerId(optionalLostBreadwinner.get());
            familyStatusAdd.setLowIncome(familyStatusDTO.getLowIncome());
            familyStatusRepository.save(familyStatusAdd);
            return new Result("Saved!", true);
    }

    @Override
    public List<FamilyStatus> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<FamilyStatus> familyStatuses = familyStatusRepository.findAll(pageable);
        return familyStatuses.getContent();
    }

    @Override
    public FamilyStatus getOne(Long id) {
        Optional<FamilyStatus> byId = familyStatusRepository.findById(id);
        return byId.orElse(null);
    }

    @Override
    public FamilyStatus edit(Long id, FamilyStatusDTO familyStatusDTO) {
        Optional<FamilyStatus> byId = familyStatusRepository.findById(id);
        Optional<FamilyCondition> optionalFamilyCondition = familyConditionRepository.findById(familyStatusDTO.getFamilyConditionId());
        Optional<Invalid> optionalInvalid = invalidRepository.findById(familyStatusDTO.getInvalidId());
        Optional<LostBreadwinner> optionalLostBreadwinner = breadwinnerRepository.findById(familyStatusDTO.getLostBreadwinnerId());
        if (byId.isPresent()) {
            FamilyStatus familyStatus = byId.get();
            familyStatus.setLowIncome(familyStatusDTO.getLowIncome());
            familyStatus.setFamilyConditionId(optionalFamilyCondition.get());
            familyStatus.setInvalidId(optionalInvalid.get());
            familyStatus.setLostBreadwinnerId(optionalLostBreadwinner.get());
            return familyStatusRepository.save(familyStatus);
        }
        return null;
    }

    @Override
    public Result delete(Long id) {
        try {
            familyStatusRepository.deleteById(id);
            return new Result("deleted",true);
        }catch (Exception e){
            return new Result("Xato!",false);
        }
    }
}
