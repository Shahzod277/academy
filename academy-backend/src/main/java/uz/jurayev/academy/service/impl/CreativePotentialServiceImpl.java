package uz.jurayev.academy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.jurayev.academy.domain.CreativePotential;
import uz.jurayev.academy.domain.Student;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.repository.CreativePotentialRepository;
import uz.jurayev.academy.repository.StudentRepository;
import uz.jurayev.academy.rest.CreativePotentialDto;
import uz.jurayev.academy.service.CreativePotentialService;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CreativePotentialServiceImpl implements CreativePotentialService {

    private final CreativePotentialRepository creativePotentialRepository;
    private final StudentRepository studentRepository;

    @Override
    public Result save(CreativePotentialDto creativePotentialDto) {
        CreativePotential creativePotential = new CreativePotential();
        if (studentRepository.findById(creativePotentialDto.getStudentId()).isEmpty()) {
            return new Result( "Creative potential with " + creativePotentialDto.getStudentId() + "not found", false);
        }
     /*   creativePotential.setName(creativePotentialDto.getName());
        creativePotential.setStudentId(creativePotentialDto.getStudentId());
        creativePotentialRepository.save(creativePotential);*/
        return new Result("creative potential saved", true);
    }

    @Override
    public Result update(Integer id, CreativePotentialDto creativePotentialDto) {
        try {
            Optional<uz.jurayev.academy.domain.CreativePotential> byId = creativePotentialRepository.findById(id);
            Optional<Student> optionalStudent = studentRepository.findById(creativePotentialDto.getStudentId() );
             if (optionalStudent.isEmpty())
                 return new Result( "Creative Potential not found", false);
             if (byId.isPresent()) {
           /*      CreativePotential creativePotential = byId.get();
                 creativePotential.setName(creativePotentialDto.getName());
                 creativePotential.setStudentId(optionalStudent.get().getId());
                 creativePotentialRepository.save(creativePotential);*/
                 return new Result("Creative Potential edited", true);
             }
             return null;
        } catch (Exception e) {
            return new Result( "error " + e.getMessage(), false);

        }

    }

    @Override
    public Page<CreativePotential> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<CreativePotential> all = creativePotentialRepository.findAll(pageable);
        return all;
    }

    @Override
    public CreativePotential getOne(Integer id) {
        try {
            Optional<CreativePotential> optionalCreativePotential = creativePotentialRepository.findById(id);
            if (optionalCreativePotential.isEmpty())
                return null;
            return optionalCreativePotential.get();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Result delete(Integer id) {
        try{
            creativePotentialRepository.deleteById(id);
            return new Result( "deleted", true);
        }catch (Exception e){
            return new Result( "error " + e.getMessage(), false);
        }
    }
}