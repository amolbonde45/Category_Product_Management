package com.Category_Product_Management.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.Category_Product_Management.Model.Category;
import com.Category_Product_Management.Repository.CategoryRepo;

@Service
public class CategoryServices {
	
	@Autowired
	public CategoryRepo categoryRepo;
	
	
	
	  public Page<Category> getCategories(int page, int size) { return
	  categoryRepo.findAll(PageRequest.of(page, size)); }
	 

	  public Category getCategoryById(Long id) {
	        return categoryRepo.findById(id).orElse(null);
	    }

	  public Category createCategory(Category category) {
	        return categoryRepo.save(category);
	    }

	   public Category updateCategory(Category category) {
	        Category existingCategory = getCategoryById(category.getId());
	        if (existingCategory != null) {
	            existingCategory.setName(category.getName());
	            return categoryRepo.save(existingCategory);
	        } else {

	            return null;
	        }
	    }

	    public void deleteCategory(Long id) {
	        categoryRepo.deleteById(id);
	    }

}
