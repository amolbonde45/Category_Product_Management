package com.Category_Product_Management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Category_Product_Management.Model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

}
