package cn.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.blog.entity.BlogCategory;
import cn.blog.mapper.BlogCategoryMapper;
import cn.blog.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private BlogCategoryMapper blogCategoryMapper;
	
	@Override
	public int getTotalCategories() {
		return blogCategoryMapper.getTotalCategories();
	}

	@Override
	public List<BlogCategory> getAllCategories() {
		return blogCategoryMapper.findAllCategory();
	}

	@Override
	public BlogCategory getCategoryById(Integer id) {
		return blogCategoryMapper.findCategoryById(id);
	}
}
