package com.ketotalk.dto;

import io.swagger.annotations.ApiModelProperty;

public class YoutubeDTO {
	@ApiModelProperty(example = "시퀀스")
	private int youtube_Seq;
	
	@ApiModelProperty(example = "유튜브 제목")
	private String youtube_Title;
	
	@ApiModelProperty(example = "유튜브 URL")
    private String youtube_Url;
	
	@ApiModelProperty(example = "유튜브 이미지")
    private String youtube_Img;
	
	@ApiModelProperty(example = "유튜브 KEY")
    private String youtube_Id;
    
	public int getYoutube_Seq() {
		return youtube_Seq;
	}
	public void setYoutube_Seq(int youtube_Seq) {
		this.youtube_Seq = youtube_Seq;
	}
	public String getYoutube_Title() {
		return youtube_Title;
	}
	public void setYoutube_Title(String youtube_Title) {
		this.youtube_Title = youtube_Title;
	}
	public String getYoutube_Url() {
		return youtube_Url;
	}
	public void setYoutube_Url(String youtube_Url) {
		this.youtube_Url = youtube_Url;
	}
	public String getYoutube_Img() {
		return youtube_Img;
	}
	public void setYoutube_Img(String youtube_Img) {
		this.youtube_Img = youtube_Img;
	}
	public String getYoutube_Id() {
		return youtube_Id;
	}
	public void setYoutube_Id(String youtube_Id) {
		this.youtube_Id = youtube_Id;
	}
    
    

}
