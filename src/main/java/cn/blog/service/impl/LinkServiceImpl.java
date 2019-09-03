package cn.blog.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.blog.entity.BlogLink;
import cn.blog.mapper.BlogLinkMapper;
import cn.blog.service.LinkService;
@Service
public class LinkServiceImpl implements LinkService {

	@Autowired
	private BlogLinkMapper blogLinkMapper;
	
	@Override
	public Map<Byte, List<BlogLink>> getLinksForType() {
		List<BlogLink> links = blogLinkMapper.findAllLink();
		List<BlogLink> favoriteLinks = new ArrayList<>();
		List<BlogLink> recommendLinks = new ArrayList<>();
		List<BlogLink> personalLinks = new ArrayList<>();
		Map<Byte, List<BlogLink>> linkMap = new HashMap<Byte, List<BlogLink>>();
		for (BlogLink blogLink : links) {
			if (blogLink.getLinkType() == 0) {
				favoriteLinks.add(blogLink);
				linkMap.put((byte) 0, favoriteLinks);
			} else if (blogLink.getLinkType() == 1) {
				recommendLinks.add(blogLink);
				linkMap.put((byte) 1, favoriteLinks);
			} else if (blogLink.getLinkType() == 2) {
				personalLinks.add(blogLink);
				linkMap.put((byte) 2, favoriteLinks);
			}
		}
		return linkMap;
	}

	@Override
	public int getTotalLinks() {
		return blogLinkMapper.getTotalLinks();
	}

}
