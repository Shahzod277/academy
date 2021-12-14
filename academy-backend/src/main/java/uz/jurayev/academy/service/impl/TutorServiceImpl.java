package uz.jurayev.academy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.jurayev.academy.domain.Tutor;
import uz.jurayev.academy.mapper.TutorMapper;
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

        if (tutorDto == null) {
            return null;
        }

        Tutor tutor = new Tutor();
        tutor.setAttachmentId(tutorDto.getAttachmentId());
        tutor.setExperience(tutorDto.getExperience());
        tutor.setPassportData(tutorDto.getPassportData());
        tutor.setNationalityId(tutorDto.getNationalityId());
        tutor.setGenderId(tutorDto.getGenderId());
        tutor.setEducationId(tutorDto.getEducationId());
        tutor.setPhoneNumber(tutorDto.getPhoneNumber());
        tutor.setTemporalAddressId(tutorDto.getTemporalAddressId());
        tutor.setAddressId(tutorDto.getAddressId());
        tutor.setBirthDate(tutorDto.getBirthDate());
        tutor.setLastname(tutorDto.getLastname());
        tutor.setName(tutorDto.getName());
        tutor.setSurname(tutorDto.getSurname());
        tutorRepository.save(tutor);
        return new Result("Tutor successfully created", true);
    }

    @Override
    public Result delete(Long id) {
        if (tutorRepository.existsById(id)) {
            tutorRepository.deleteById(id);
            return new Result("Tutor with id " + id + " successfully deleted", true);
        }
        return new Result("Tutor with id " + id + " not found", false);
    }

    @Override
    public List<TutorDto> findAll() {
        List<Tutor> tutors = tutorRepository.findAll();
        return TutorMapper.INSTANCE.toTutorDtos(tutors);
    }

    @Override
    public TutorDto findById(Long id) {
        Optional<Tutor> tutorById = tutorRepository.findById(id);
        return tutorById.map(TutorMapper.INSTANCE::toTutorDto).orElse(null);
    }

    @Override
    public Result update(Long id, TutorDto tutorDto) {
        Optional<Tutor> tutorById = tutorRepository.findById(id);
        if (tutorById.isPresent()) {
            Tutor tutor = tutorById.get();
            tutor.setAttachmentId(tutorDto.getAttachmentId());
            tutor.setExperience(tutorDto.getExperience());
            tutor.setPassportData(tutorDto.getPassportData());
            tutor.setNationalityId(tutorDto.getNationalityId());
            tutor.setGenderId(tutorDto.getGenderId());
            tutor.setEducationId(tutorDto.getEducationId());
            tutor.setPhoneNumber(tutorDto.getPhoneNumber());
            tutor.setTemporalAddressId(tutorDto.getTemporalAddressId());
            tutor.setAddressId(tutorDto.getAddressId());
            tutor.setBirthDate(tutorDto.getBirthDate());
            tutor.setLastname(tutorDto.getLastname());
            tutor.setName(tutorDto.getName());
            tutor.setSurname(tutorDto.getSurname());
            tutorRepository.save(tutor);
            return new Result("Tutor with id " + id + " successfully updated", true);
        }
        return new Result("Tutor with id " + id + " not found", false);
    }
}
