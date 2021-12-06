package com.ketotalk.dto;

public class DiseaseListDTO {
	private int disease_seq;
	private String disease_name;
	private String disease_content;
	private String disease_name_un;
	private String disease_category;
	private String remark;
	
	
	public int getDisease_seq() {
		return disease_seq;
	}
	public void setDisease_seq(int disease_seq) {
		this.disease_seq = disease_seq;
	}
	public String getDisease_name() {
		return disease_name;
	}
	public void setDisease_name(String disease_name) {
		this.disease_name = disease_name;
	}
	public String getDisease_content() {
		return disease_content;
	}
	public void setDisease_content(String disease_content) {
		this.disease_content = disease_content;
	}
	public String getDisease_name_un() {
		return disease_name_un;
	}
	public void setDisease_name_un(String disease_name_un) {
		this.disease_name_un = disease_name_un;
	}
	public String getDisease_category() {
		return disease_category;
	}
	public void setDisease_category(String disease_category) {
		this.disease_category = disease_category;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
