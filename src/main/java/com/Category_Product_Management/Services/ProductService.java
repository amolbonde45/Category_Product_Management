package com.Category_Product_Management.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.Category_Product_Management.Model.Product;
import com.Category_Product_Management.Repository.ProductRepo;

public class ProductService {
	
	@Autowired
	public ProductRepo productRepo;
	
	
	  public Page<Product> getProducts(int page, int size) {
	        return productRepo.findAll(PageRequest.of(page, size));
	    }
	  
	  public Product getProductById(Long id) {
	        return productRepo.findById(id).orElse(null);
	    }

	    public Product createProduct(Product product) {
	        return productRepo.save(product);
	    }

	    public Product updateProduct(Product product) {
	        Product existingProduct = getProductById(product.getId());
	        if (existingProduct != null) {
	            existingProduct.setName(product.getName());
	            existingProduct.setPrice(product.getPrice());
	            existingProduct.setCategory(product.getCategory());
	            return productRepo.save(existingProduct);
	        } else {
	            return null;
	        }
	    }

	    public void deleteProduct(Long id) {
	        productRepo.deleteById(id);
	    }


}
