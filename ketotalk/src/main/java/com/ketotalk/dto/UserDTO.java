package com.ketotalk.dto;

import io.swagger.annotations.ApiModelProperty;

public class UserDTO {
	
	@ApiModelProperty(example = "유저 번호")
	private int user_seq;
	
	@ApiModelProperty(example = "유저 고유 디바이스 번호")
	private String user_id;
	
	@ApiModelProperty(example = "유저 생년월일")
	private String user_birth;
	
	@ApiModelProperty(example = "유저 성별")
	private String user_sex;
	
	@ApiModelProperty(example = "유저 이름")
	private String user_nickname;
	
	
	public int getUser_seq() {
		return user_seq;
	}
	public void setUser_seq(int user_seq) {
		this.user_seq = user_seq;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_birth() {
		return user_birth;
	}
	public void setUser_birth(String user_birth) {
		this.user_birth = user_birth;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	
	
}
