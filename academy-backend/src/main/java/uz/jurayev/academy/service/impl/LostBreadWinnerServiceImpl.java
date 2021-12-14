package uz.jurayev.academy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.jurayev.academy.domain.LostBreadwinner;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.repository.LostBreadwinnerRepository;
import uz.jurayev.academy.service.LostBreadWinnerSerivce;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LostBreadWinnerServiceImpl implements LostBreadWinnerSerivce {

    final private LostBreadwinnerRepository LostBreadwinnerRepository;

    @Override
    public Result Add(LostBreadwinner breadwinner) {
        if (!LostBreadwinnerRepository.existsByName(breadwinner.getName())) {
            LostBreadwinner LostBreadwinner = new LostBreadwinner();
            LostBreadwinner.setName(breadwinner.getName());
            LostBreadwinnerRepository.save(LostBreadwinner);
            return new Result("Saved!", true);
        }
        return new Result("Bunday LostBreadwinnerlik turi bor!", false);
    }

    @Override
    public List<LostBreadwinner> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<LostBreadwinner> lostBreadwinners = LostBreadwinnerRepository.findAll(pageable);
        return lostBreadwinners.getContent();
    }

    @Override
    public LostBreadwinner getOne(Long id) {
        Optional<LostBreadwinner> byId = LostBreadwinnerRepository.findById(id);
        return byId.orElse(null);
    }

    @Override
    public LostBreadwinner edit(Long id, LostBreadwinner lostBreadwinner) {
        Optional<LostBreadwinner> byId = LostBreadwinnerRepository.findById(id);
        if (byId.isPresent()) {
            LostBreadwinner lostBreadwinnerEdit = new LostBreadwinner();
            lostBreadwinnerEdit.setName(lostBreadwinner.getName());
            return LostBreadwinnerRepository.save(lostBreadwinnerEdit);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        try {
            LostBreadwinnerRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
