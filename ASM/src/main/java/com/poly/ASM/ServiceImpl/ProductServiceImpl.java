package com.poly.ASM.ServiceImpl;

import com.poly.ASM.Service.ProductService;
import com.poly.ASM.dao.ProductRepository;
import com.poly.ASM.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepo;
    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepo.findAll(pageable);
    }

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public List<Product> findByCategory(String cid) {
        return productRepo.findByCategoryId(cid);
    }

    @Override
    public Product create(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product update(Product product) {
        return productRepo.save(product);
    }

    @Override
    public void delete(Integer id) {
        productRepo.deleteById(id);
    }
}

