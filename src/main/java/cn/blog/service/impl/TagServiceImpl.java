package cn.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.blog.entity.BlogTagCount;
import cn.blog.mapper.BlogTagMapper;
import cn.blog.service.TagService;
@Service
public class TagServiceImpl implements TagService {

	@Autowired
	private BlogTagMapper blogTagMapper;
	
	public List<BlogTagCount> getBlogTagCount() {
		return blogTagMapper.getTagCount();
	}

	@Override
	public int getTotalTags() {
		return blogTagMapper.getTotalTags();
	}
}
