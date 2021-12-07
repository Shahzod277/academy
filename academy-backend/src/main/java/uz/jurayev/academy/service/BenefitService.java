package uz.jurayev.academy.service;

import uz.jurayev.academy.domain.Benefit;
import uz.jurayev.academy.model.Result;
import java.util.List;


public interface BenefitService {
    Result save(Benefit benefit);

    Result edit(Long id, Benefit benefit);

    List<Benefit> getAllBenefit(int page, int size);

    Benefit getOneBenefit(Long id);

    Result deleteBenefit(Long id);
}
