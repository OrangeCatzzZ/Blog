package cn.blog.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.blog.entity.BlogConfig;
import cn.blog.mapper.BlogConfigMapper;
import cn.blog.service.ConfigService;

@Service
public class ConfigServiceImpl implements ConfigService {

	@Autowired
	private BlogConfigMapper blogConfigMapper;

	public Map<String, String> getAllConfigs() {
		List<BlogConfig> blogConfigs = blogConfigMapper.findAllConfigs();
		Map<String, String> configMap = blogConfigs.stream()
				.collect(Collectors.toMap(BlogConfig::getConfigName, BlogConfig::getConfigValue));
		return configMap;
	}

}
