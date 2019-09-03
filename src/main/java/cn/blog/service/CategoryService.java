package cn.blog.service;

import java.util.List;

import cn.blog.entity.BlogCategory;

public interface CategoryService {
	
	int getTotalCategories();
	
	List<BlogCategory> getAllCategories();
	
	BlogCategory getCategoryById(Integer id);
}
