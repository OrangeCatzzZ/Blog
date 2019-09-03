package cn.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cn.blog.entity.BlogCategory;

@Mapper
public interface BlogCategoryMapper {
	
	@Select("SELECT COUNT(*) FROM tb_blog_category")
	int getTotalCategories();
	
	@Select("SELECT * FROM tb_blog_category")
	List<BlogCategory> findAllCategory();
	
	@Select("SELECT * FROM tb_blog_category WHERE category_id = #{id}")
	BlogCategory findCategoryById(Integer id);
}
