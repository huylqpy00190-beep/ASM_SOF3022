package com.poly.ASM.dao;

import com.poly.ASM.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository
        extends JpaRepository<Product, Integer> {

    // 1. Sản phẩm theo loại
    List<Product> findByCategoryId(String categoryId);

    // 2. Sản phẩm mới nhất
    @Query("SELECT p FROM Product p ORDER BY p.createDate DESC")
    Page<Product> findAllOrderByDate(Pageable pageable);

    // 3. Sản phẩm bán chạy (dựa OrderDetail)
    @Query("""
        SELECT od.product
        FROM OrderDetail od
        GROUP BY od.product
        ORDER BY SUM(od.quantity) DESC
    """)
    List<Product> findBestSeller(Pageable pageable);

    // 4. Sản phẩm giảm giá (giả sử price thấp)
    @Query("SELECT p FROM Product p WHERE p.price < ?1")
    List<Product> findDiscount(double price);

    // 5. Tìm theo khoảng giá
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN ?1 AND ?2")
    List<Product> findByPriceRange(double min, double max);

    // 6. Tìm theo tên
    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%")
    List<Product> searchByName(String keyword);

}


