package cn.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cn.blog.entity.BlogConfig;

@Mapper
public interface BlogConfigMapper {
	
	@Select("SELECT * FROM tb_config")
	List<BlogConfig> findAllConfigs();
	
}
