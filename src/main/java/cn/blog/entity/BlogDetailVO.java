package cn.blog.entity;

import java.util.Date;
import java.util.List;

public class BlogDetailVO {
    private Long blogId;

    private String blogTitle;

    private Integer commentCount;

    private Long blogViews;

    private List<String> blogTags;

    private String blogContent;

    private Byte enableComment;

    private Date createTime;

	public Long getBlogId() {
		return blogId;
	}

	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	public Long getBlogViews() {
		return blogViews;
	}

	public void setBlogViews(Long blogViews) {
		this.blogViews = blogViews;
	}

	public List<String> getBlogTags() {
		return blogTags;
	}

	public void setBlogTags(List<String> blogTags) {
		this.blogTags = blogTags;
	}

	public String getBlogContent() {
		return blogContent;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}

	public Byte getEnableComment() {
		return enableComment;
	}

	public void setEnableComment(Byte enableComment) {
		this.enableComment = enableComment;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "BlogDetailVO [blogId=" + blogId + ", blogTitle=" + blogTitle + ", commentCount=" + commentCount
				+ ", blogViews=" + blogViews + ", blogTags=" + blogTags + ", blogContent=" + blogContent
				+ ", enableComment=" + enableComment + ", createTime=" + createTime + "]";
	}
}
