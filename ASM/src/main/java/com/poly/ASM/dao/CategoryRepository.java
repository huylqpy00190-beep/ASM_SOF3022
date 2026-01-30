package com.poly.ASM.dao;

import com.poly.ASM.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository
        extends JpaRepository<Category, String> {

    @Query("SELECT c FROM Category c WHERE c.name LIKE %?1%")
    List<Category> searchByName(String keyword);
}

