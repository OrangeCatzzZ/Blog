package cn.blog.entity;

public class SimpleTagVO {
	private String blogTags;

	public String getBlogTags() {
		return blogTags;
	}

	public void setBlogTags(String blogTags) {
		this.blogTags = blogTags;
	}

	@Override
	public String toString() {
		return "SimpleTagVo [blogTags=" + blogTags + "]";
	}
}
