package cn.blog.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.blog.entity.AdminUser;
import cn.blog.service.AdminUserService;
import cn.blog.service.BlogService;
import cn.blog.service.CategoryService;
import cn.blog.service.CommentService;
import cn.blog.service.LinkService;
import cn.blog.service.TagService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminUserService adminUserService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private BlogService blogService;
	@Autowired
	private LinkService linkService;
	@Autowired
	private TagService tagService;
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/login")
	public String login() {
		return "admin/login";
	}
	
	@PostMapping("/login")
	public String login(String userName, String password, String verifyCode, HttpSession session) {
		if (StringUtils.isEmpty(verifyCode)) {
            session.setAttribute("errorMsg", "验证码不能为空");
            return "admin/login";
        }
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            session.setAttribute("errorMsg", "用户名或密码不能为空");
            return "admin/login";
        }
        String kaptchaCode = session.getAttribute("verifyCode") + "";
        if (StringUtils.isEmpty(kaptchaCode) || !verifyCode.equals(kaptchaCode)) {
            session.setAttribute("errorMsg", "验证码错误");
            return "admin/login";
        }
        AdminUser adminUser = adminUserService.login(userName, password);
        if (adminUser != null) {
        	session.setAttribute("loginUser", adminUser.getNickName());
            session.setAttribute("loginUserId", adminUser.getAdminUserId());
            //session过期时间设置为7200秒 即两小时
            session.setMaxInactiveInterval(60 * 60 * 2);
            return "redirect:/admin/index";
		} else {
			session.setAttribute("errorMsg", "登陆失败");
			return "admin/login";
		}
	}
	
	@GetMapping({"", "/", "/index"})
    public String index(HttpServletRequest request) {
		request.setAttribute("path", "index");
        request.setAttribute("categoryCount", categoryService.getTotalCategories());
        request.setAttribute("blogCount", blogService.getTotalBlogs());
        request.setAttribute("linkCount", linkService.getTotalLinks());
        request.setAttribute("tagCount", tagService.getTotalTags());
        request.setAttribute("commentCount", commentService.getTotalComments());
		return "admin/index";
	}
}
