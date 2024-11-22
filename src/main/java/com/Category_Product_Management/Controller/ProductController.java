package com.Category_Product_Management.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Category_Product_Management.Model.Product;
import com.Category_Product_Management.Services.ProductService;
@Controller
@RequestMapping("/api/product")
public class ProductController {
	
	 @Autowired
	    public ProductService productService;

	    @GetMapping
	    public ResponseEntity<Page<Product>> getAllProducts(@RequestParam(defaultValue = "0") int page,
	                                                        @RequestParam(defaultValue = "10") int size) {
	        return new ResponseEntity<>(productService.getProducts(page, size), HttpStatus.OK);
	    }

	    @GetMapping("/api/products/{id}")
	    public Product getProductById(@PathVariable Long id) {
	        return productService.getProductById(id);
	    }

	    @PostMapping("/api/products")
	    public Product createProduct(@RequestBody Product product) {
	        return productService.createProduct(product);
	    }

	    @PutMapping("/api/products/{id}")
	    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
	        product.setId(id);
	        return productService.updateProduct(product);
	    }

	    @DeleteMapping("/api/products/{id}")
	    public void deleteProduct(@PathVariable Long id) {
	        productService.deleteProduct(id);
	    }

}
