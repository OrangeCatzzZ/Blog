package cn.blog.service;

import java.util.Map;

public interface ConfigService {
	
	/**
	 * 获得所有配置信息的键值对
	 * @return
	 */
	Map<String, String> getAllConfigs();
	
}
