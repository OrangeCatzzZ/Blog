package cn.blog.service;

import java.util.List;
import java.util.Map;

import cn.blog.entity.BlogLink;

public interface LinkService {
	
	int getTotalLinks();
	
	/**
	 * 获得友链 并根据类别封装数据
	 * 0-友链 1-推荐 2-个人网站
	 * @return
	 */
	Map<Byte, List<BlogLink>> getLinksForType();
	
}
