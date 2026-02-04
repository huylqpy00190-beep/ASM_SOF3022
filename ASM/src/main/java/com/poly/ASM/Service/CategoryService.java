package com.poly.ASM.Service;

import com.poly.ASM.entity.Category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(String id);
    Category create(Category category);
    Category update(Category category);
    void delete(String id);
    Page<Category> findAll(Pageable pageable);
}

