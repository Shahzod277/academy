package uz.jurayev.academy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.jurayev.academy.domain.Benefit;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.repository.BenefitRepository;
import uz.jurayev.academy.service.BenefitService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BenefitServiceImpl implements BenefitService {

    private final BenefitRepository benefitRepository;

    @Override
    public Result save(Benefit benefit) {
        try {
            boolean existsByName = benefitRepository.existsByName(benefit.getName());
            if (!existsByName) {
                return new Result("already exists", false);
            }
            Benefit addBenefit = new Benefit();
            addBenefit.setName(benefit.getName());
            benefitRepository.save(benefit);
            return new Result("saved successfull data", true);
        } catch (Exception e) {
            return new Result("" + e.getMessage(), false);
        }
    }

    @Override
    public Result edit(Long id, Benefit benefit) {
        try {
            Optional<Benefit> optionalBenefit = benefitRepository.findById(id);
            Benefit editBenefit = optionalBenefit.get();
            editBenefit.setName(benefit.getName());
            benefitRepository.save(editBenefit);
            return new Result("edited", true);
        } catch (Exception e) {
            return new Result("" + e.getMessage(), false);
        }
    }

    @Override
    public List<Benefit> getAllBenefit(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Benefit> all = benefitRepository.findAll(pageable);
        return all.getContent();
    }

    @Override
    public Benefit getOneBenefit(Long id) {
        try {
            Optional<Benefit> optionalBenefit = benefitRepository.findById(id);
            if (optionalBenefit.isPresent()) {
                return optionalBenefit.get();
            }
        } catch (Exception sh) {
            return null;
        }
        return null;
    }

    @Override
    public Result deleteBenefit(Long id) {
        try {
            benefitRepository.deleteById(id);
            return new Result("deleted data", true);
        } catch (Exception e) {
            return new Result("id not found ", true);
        }
    }
}
