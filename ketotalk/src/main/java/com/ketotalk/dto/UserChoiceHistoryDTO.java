package com.ketotalk.dto;

public class UserChoiceHistoryDTO {
	private int choice_seq;
	private String user_id;
	private int q1_selected_seq;
	private String upper_q_seq_selected_seq;
	
	
	public int getChoice_seq() {
		return choice_seq;
	}
	public void setChoice_seq(int choice_seq) {
		this.choice_seq = choice_seq;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getQ1_selected_seq() {
		return q1_selected_seq;
	}
	public void setQ1_selected_seq(int q1_selected_seq) {
		this.q1_selected_seq = q1_selected_seq;
	}
	public String getUpper_q_seq_selected_seq() {
		return upper_q_seq_selected_seq;
	}
	public void setUpper_q_seq_selected_seq(String upper_q_seq_selected_seq) {
		this.upper_q_seq_selected_seq = upper_q_seq_selected_seq;
	}
	
	
}
