package cn.blog.mapper.provider;

import org.apache.ibatis.annotations.Param;
/**
 * mybatis工具类,根据复杂的业务需求来动态生成SQL
 */
public class BlogSqlProvider {

	private static final String find_simpleList = "SELECT blog_id, blog_title FROM tb_blog";

	public String findBlogListByType(@Param("type") int type) {
		if (type == 0) {
			return find_simpleList + " ORDER BY blog_views DESC LIMIT 9";
		} else if (type == 1) {
			return find_simpleList + " ORDER BY blog_id DESC LIMIT 9";
		}
		return null;
	}

}
