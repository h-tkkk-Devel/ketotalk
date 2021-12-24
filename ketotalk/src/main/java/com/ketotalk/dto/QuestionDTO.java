package com.ketotalk.dto;

public class QuestionDTO {
	private int q_seq;
	private int upper_q_seq;
	private String common_q_yn;
	private String category;
	private String category_sub;
	private String q_contents;
	private String select_type;
	private int order_no;
	private String use_yn;
	private String question_rule;
	
	
	public int getQ_seq() {
		return q_seq;
	}
	public void setQ_seq(int q_seq) {
		this.q_seq = q_seq;
	}
	public int getUpper_q_seq() {
		return upper_q_seq;
	}
	public void setUpper_q_seq(int upper_q_seq) {
		this.upper_q_seq = upper_q_seq;
	}
	public String getCommon_q_yn() {
		return common_q_yn;
	}
	public void setCommon_q_yn(String common_q_yn) {
		this.common_q_yn = common_q_yn;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCategory_sub() {
		return category_sub;
	}
	public void setCategory_sub(String category_sub) {
		this.category_sub = category_sub;
	}
	public String getQ_contents() {
		return q_contents;
	}
	public void setQ_contents(String q_contents) {
		this.q_contents = q_contents;
	}
	public String getSelect_type() {
		return select_type;
	}
	public void setSelect_type(String select_type) {
		this.select_type = select_type;
	}
	public int getOrder_no() {
		return order_no;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	public String getUse_yn() {
		return use_yn;
	}
	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	public String getQuestion_rule() {
		return question_rule;
	}
	public void setQuestion_rule(String question_rule) {
		this.question_rule = question_rule;
	}
	
	
	
}
