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

    final private LostBreadwinnerRepository lostBreadwinnerRepository;

    @Override
    public Result Add(LostBreadwinner breadwinner) {
        if (!lostBreadwinnerRepository.existsByName(breadwinner.getName())) {
            LostBreadwinner lostBreadwinner = new LostBreadwinner();
            lostBreadwinner.setName(breadwinner.getName());
            lostBreadwinnerRepository.save(lostBreadwinner);
            return new Result("Saved!", true);
        }
        return new Result("Bunday LostBreadwinnerlik turi bor!", false);
    }

    @Override
    public List<LostBreadwinner> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<LostBreadwinner> lostBreadwinners = lostBreadwinnerRepository.findAll(pageable);
        return lostBreadwinners.getContent();
    }

    @Override
    public LostBreadwinner getOne(Long id) {
        Optional<LostBreadwinner> byId = lostBreadwinnerRepository.findById(id);
        return byId.orElse(null);
    }

    @Override
    public LostBreadwinner edit(Long id, LostBreadwinner lostBreadwinner) {
        Optional<LostBreadwinner> byId = lostBreadwinnerRepository.findById(id);
        if (byId.isPresent()) {
            LostBreadwinner lostBreadwinnerEdit = byId.get();
            lostBreadwinnerEdit.setName(lostBreadwinner.getName());
            return lostBreadwinnerRepository.save(lostBreadwinnerEdit);
        }
        return null;
    }

    @Override
    public Result delete(Long id) {
        try {
            lostBreadwinnerRepository.deleteById(id);
            return new Result("deleted",true);
        }catch (Exception e){
            return new Result("Xato!",false);
        }
    }
}
