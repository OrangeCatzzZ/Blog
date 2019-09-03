package cn.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import cn.blog.entity.Blog;
import cn.blog.entity.BlogDetailVO;
import cn.blog.entity.SimpleBlogListVO;
import cn.blog.mapper.provider.BlogSqlProvider;

@Mapper
public interface BlogMapper {

	@Select("SELECT * FROM tb_blog ORDER BY blog_id DESC")
	List<Blog> findAllBlog();

	@SelectProvider(type = BlogSqlProvider.class, method = "findBlogListByType")
	List<SimpleBlogListVO> findBlogListByType(@Param("type") int type);

	@Select("SELECT blog_title, blog_views, blog_content, enable_comment, create_time FROM tb_blog WHERE blog_id=#{blogId}")
	BlogDetailVO findBlogDetailById(long blogId);

	@Select("SELECT * FROM tb_blog WHERE blog_id IN (SELECT blog_id FROM tb_blog_tag_relation WHERE tag_id =#{tagId})")
	List<Blog> getBlogsByTagId(Integer tagId);

	@Select("SELECT * FROM tb_blog WHERE blog_title LIKE '%${keyword}%' OR blog_category_name LIKE '%${keyword}%'")
	List<Blog> searchBlogBykeyword(@Param("keyword") String keyword);
	
//	@Select("SELECT * FROM tb_blog WHERE blog_title LIKE CONCAT('%','${keyword}','%' ) or blog_category_name like CONCAT('%','${keyword}','%' )")
//	List<Blog> search(@Param("keyword") String keyword);
	
	@Select("SELECT COUNT(*) FROM tb_blog")
	int getTotalBlogs();
	
	@Insert("INSERT INTO tb_blog (blog_title, blog_sub_url, blog_cover_image, blog_content, blog_category_id, blog_category_name, blog_tags, blog_status, enable_comment) "
			+ "VALUES(#{blogTitle},#{blogSubUrl},#{blogCoverImage},#{blogContent},#{blogCategoryId},#{blogCategoryName},#{blogTags},#{blogStatus},#{enableComment})")
	void insert(Blog blog);
}
