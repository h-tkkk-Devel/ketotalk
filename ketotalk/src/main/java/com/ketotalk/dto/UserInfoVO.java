package com.ketotalk.dto;

public class UserInfoVO {
	private int user_seq;
	private String user_id;
	private String user_birth;
	private String user_sex;
	private String user_nickname;
	private int choice_seq;
	private String reg_date;
	private String result_desease_name;
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
	public int getChoice_seq() {
		return choice_seq;
	}
	public void setChoice_seq(int choice_seq) {
		this.choice_seq = choice_seq;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getResult_desease_name() {
		return result_desease_name;
	}
	public void setResult_desease_name(String result_desease_name) {
		this.result_desease_name = result_desease_name;
	}
	
	
}
