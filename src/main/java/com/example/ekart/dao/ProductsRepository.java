package com.example.ekart.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.ekart.model.Products;


public interface ProductsRepository extends PagingAndSortingRepository<Products, Long> {
	List<Products> findByBrandContainingOrCategoryContainingOrSubcategoryContaining(String brand,String category,String subcategory,Pageable pageable);
}
