package cn.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cn.blog.entity.BlogLink;

@Mapper
public interface BlogLinkMapper {

	@Select("SELECT * FROM tb_link")
	List<BlogLink> findAllLink();

	@Select("SELECT COUNT(*) FROM tb_link")
	int getTotalLinks();
}
