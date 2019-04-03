package com.example.ekart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ekart.dao.ProductsRepository;
import com.example.ekart.model.Products;


@RestController
@RequestMapping("/products")
public class ProductsController {
	
	@Autowired
	private ProductsRepository productsRepository;

	@GetMapping("/")
	public List<Products> getProducts(){
		return (List<Products>) productsRepository.findAll();
	}
	
	@GetMapping("/search")
	public List<Products> searchtProducts(String searchQuery){
		Pageable page= PageRequest.of(0, 3, Sort.by("name"));
		return (List<Products>) productsRepository.findByBrandContainingOrCategoryContainingOrSubcategoryContaining(searchQuery, searchQuery, searchQuery,page);
	}
	
	

}
