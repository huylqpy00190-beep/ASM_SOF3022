package com.poly.ASM.ServiceImpl;

import com.poly.ASM.Service.CategoryService;
import com.poly.ASM.dao.CategoryRepository;
import com.poly.ASM.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepo;

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepo.findAll(pageable);
    }
    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category findById(String id) {
        return categoryRepo.findById(id).orElse(null);
    }

    @Override
    public Category create(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public Category update(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public void delete(String id) {
        categoryRepo.deleteById(id);
    }


}

