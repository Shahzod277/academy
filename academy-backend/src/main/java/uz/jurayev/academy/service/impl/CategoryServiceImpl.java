package uz.jurayev.academy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.jurayev.academy.domain.Category;
import uz.jurayev.academy.domain.CreativePotential;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.repository.CategoryRepository;
import uz.jurayev.academy.repository.CreativePotentialRepository;
import uz.jurayev.academy.rest.CategoryDto;
import uz.jurayev.academy.service.CategoryService;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CreativePotentialRepository creativePotentialRepository;

    @Override
    public Result save(CategoryDto categoryDto) {
        Category save = new Category();
        Optional<CreativePotential> optionalCreativePotential
                = creativePotentialRepository.findById(categoryDto.getCreativePotentialId());
        if (optionalCreativePotential.isEmpty())
            return new Result("not saved, not found creative potential", false);
        save.setName(categoryDto.getName());
        save.setCreativePotentialId(categoryDto.getCreativePotentialId());
        categoryRepository.save(save);
        return new Result( "saved", true);
    }

    @Override
    public Result update(Long id, CategoryDto categoryDto) {
        try {
            Optional<Category> byId = categoryRepository.findById(id);
            Optional<CreativePotential> creativePotential
                    = creativePotentialRepository.findById(categoryDto.getCreativePotentialId());
            if (creativePotential.isEmpty())
                return new Result("not found creative potential", false);
            Category editCategory = byId.get();
            editCategory.setName(categoryDto.getName());
            editCategory.setCreativePotentialId(creativePotential.get().getId());
            categoryRepository.save(editCategory);
            return new Result("edited", true);
        }catch (Exception e){
            return new Result("error " + e.getMessage(), false);
        }
    }

    @Override
    public Page<Category> page(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Category> all = categoryRepository.findAll(pageable);
        return all;
    }

    @Override
    public Category getOne(Long id) {
        try {
            Optional<Category> categoryById =
                    categoryRepository.findById(id);
            if (categoryById.isEmpty())
                return null;
            return categoryById.get();
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public Result delete(Long id) {
        try{
            categoryRepository.deleteById(id);
            return new Result("deleted", true);
        }catch (Exception e){
            return new Result("error " + e.getMessage(), false);
        }
    }
}
