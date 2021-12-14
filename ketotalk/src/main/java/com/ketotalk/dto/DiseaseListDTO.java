package com.ketotalk.dto;

import io.swagger.annotations.ApiModelProperty;

public class DiseaseListDTO {
	
	@ApiModelProperty(example = "질환 번호")
	private int disease_seq;
	
	@ApiModelProperty(example = "질환명")
	private String disease_name;
	
	@ApiModelProperty(example = "질환 정의")
	private String disease_content;
	
	@ApiModelProperty(example = "질환 영문명")
	private String disease_name_un;
	
	@ApiModelProperty(example = "질환 카테고리")
	private String disease_category;
	
	@ApiModelProperty(example = "비고")
	private String remark;
	
	@ApiModelProperty(example = "원인 및 증상")
	private String disease_symptom;
	
	@ApiModelProperty(example = "진단 및 치료")
	private String disease_cure;
	
	
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
	public String getDisease_symptom() {
		return disease_symptom;
	}
	public void setDisease_symptom(String disease_symptom) {
		this.disease_symptom = disease_symptom;
	}
	public String getDisease_cure() {
		return disease_cure;
	}
	public void setDisease_cure(String disease_cure) {
		this.disease_cure = disease_cure;
	}
	
	
}
