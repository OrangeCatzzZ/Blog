package cn.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cn.blog.entity.BlogTag;
import cn.blog.entity.BlogTagCount;
import cn.blog.entity.SimpleTagVO;

@Mapper
public interface BlogTagMapper {
	
	@Select("SELECT tag_id, tag_name, tag_count FROM tb_blog_tag ORDER BY tag_count DESC")
	List<BlogTagCount> getTagCount();
	
	@Select("SELECT blog_tags FROM tb_blog WHERE blog_id = #{blogId}")
	List<String> findTagById(long blogId);
	
	@Select("SELECT COUNT(*) FROM tb_blog_tag")
	int getTotalTags();
}
