package cn.blog.service;

import java.util.List;

import cn.blog.entity.BlogTagCount;

public interface TagService {
	
	List<BlogTagCount> getBlogTagCount();
	
	int getTotalTags();
}
