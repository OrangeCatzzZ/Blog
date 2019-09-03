package cn.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.blog.entity.AdminUser;

@Mapper
public interface AdminUserMapper {
	
	/**
     * 登陆方法
     * @param userName
     * @param password
     * @return
     */
	@Select("SELECT * FROM tb_admin_user WHERE login_user_name = #{userName} AND login_password =#{password}")
    AdminUser login(@Param("userName") String userName, @Param("password") String password);
}
