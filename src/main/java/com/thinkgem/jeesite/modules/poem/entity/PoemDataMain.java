/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.poem.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 单表生成Entity
 * @author lsh
 * @version 2018-09-08
 */
public class PoemDataMain extends DataEntity<PoemDataMain> {
	
	private static final long serialVersionUID = 1L;
	private String type;		// 类型
	private String author;		// 作者
	private String poemName;		// 诗名
	private String dynasty;		// 朝代
	private String content;		// 内容
	private String summary;		// 摘句
	private String appreciate;		// 鉴赏
	
	public PoemDataMain() {
		super();
	}

	public PoemDataMain(String id){
		super(id);
	}

	@Length(min=1, max=64, message="类型长度必须介于 1 和 64 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=0, max=64, message="作者长度必须介于 0 和 64 之间")
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Length(min=0, max=255, message="诗名长度必须介于 0 和 255 之间")
	public String getPoemName() {
		return poemName;
	}

	public void setPoemName(String poemName) {
		this.poemName = poemName;
	}
	
	@Length(min=0, max=64, message="朝代长度必须介于 0 和 64 之间")
	public String getDynasty() {
		return dynasty;
	}

	public void setDynasty(String dynasty) {
		this.dynasty = dynasty;
	}
	
	@Length(min=0, max=1024, message="内容长度必须介于 0 和 1024 之间")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Length(min=0, max=512, message="摘句长度必须介于 0 和 512 之间")
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public String getAppreciate() {
		return appreciate;
	}

	public void setAppreciate(String appreciate) {
		this.appreciate = appreciate;
	}
	
}