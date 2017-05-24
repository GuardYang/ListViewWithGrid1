package com.byl.listviewwithgrid.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author 白玉梁
 */
@SuppressWarnings("serial")
public class TestBean implements Serializable{

	public String username;//昵称
	public String headphoto;//头像
	public String content;//发布内容
	public String time;//发布时间
	public String images;//图片
	public List<String> imgPath;


	public List<String> getImgPath() {
		return imgPath;
	}

	public void setImgPath(List<String> imgPath) {
		this.imgPath = imgPath;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getHeadphoto() {
		return headphoto;
	}
	public void setHeadphoto(String headphoto) {
		this.headphoto = headphoto;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	
	
	
	

}
