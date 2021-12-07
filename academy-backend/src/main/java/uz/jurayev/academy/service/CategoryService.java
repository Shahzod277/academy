package uz.jurayev.academy.service;

import org.springframework.data.domain.Page;
import uz.jurayev.academy.domain.Category;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.CategoryDto;

public interface CategoryService {

    Result save(CategoryDto categoryDto);

    Result update(Long id,CategoryDto categoryDto);

    Page<Category> page(int page, int size);

    Category getOne(Long id);

    Result delete(Long id);

}
