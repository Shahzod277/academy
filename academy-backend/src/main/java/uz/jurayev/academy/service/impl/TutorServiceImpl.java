package uz.jurayev.academy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.jurayev.academy.domain.Tutor;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.repository.TutorRepository;
import uz.jurayev.academy.rest.TutorDto;
import uz.jurayev.academy.service.TutorService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TutorServiceImpl implements TutorService {

    private final TutorRepository tutorRepository;

    @Override
    public Result create(TutorDto tutorDto) {

        return new Result("Tutor successfully created", true);
    }

    @Override
    public Result delete(Long id) {
        return null;
    }

    @Override
    public List<TutorDto> findAll() {
        return null;
    }

    @Override
    public TutorDto findById(Long id) {
        return null;
    }

    @Override
    public Result update(Long id, TutorDto tutorDto) {
        return null;
    }
}
