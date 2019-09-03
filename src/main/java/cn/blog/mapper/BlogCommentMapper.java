package cn.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BlogCommentMapper {
	
	@Select("SELECT COUNT(*) FROM tb_blog_comment WHERE blog_id = #{blogId}")
	int getTotalBlogComments(long blogId);
	
	@Select("SELECT COUNT(*) FROM tb_blog_comment")
	int getTotalComments();
}
