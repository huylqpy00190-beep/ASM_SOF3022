package com.poly.ASM.Service;

import com.poly.ASM.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Integer id);
    List<Product> findByCategory(String cid);
    Product create(Product product);
    Product update(Product product);
    void delete(Integer id);
    Page<Product> findAll(Pageable pageable);
}

