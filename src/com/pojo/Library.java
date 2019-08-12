package com.pojo;

public class Library {
	private int ques_id;
//	private String ques_name;
	private String option_1;
	private String option_2;
	private String option_3;
	private String option_4;
	private int level_id;
	
	public Library() {}
	
//	public Library(int ques_id,String ques_name,String option_1,String option_2,String option_3,String option_4,int level_id) {
//		this.ques_id = ques_id;
//		this.ques_name = ques_name;
//		this.option_1 = option_1;
//		this.option_2 = option_2;
//		this.option_3 = option_3;
//		this.option_4 = option_4;
//		this.level_id = level_id;
//	}
	
	public int getQues_id() {
		return ques_id;
	}
	
	public Library(int ques_id, String option_1, String option_2, String option_3, String option_4, int level_id) {
		this.ques_id = ques_id;
		this.option_1 = option_1;
		this.option_2 = option_2;
		this.option_3 = option_3;
		this.option_4 = option_4;
		this.level_id = level_id;
	}

	public void setQues_id(int ques_id) {
		this.ques_id = ques_id;
	}
//	public String getQues_name() {
//		return ques_name;
//	}
//	public void setQues_name(String ques_name) {
//		this.ques_name = ques_name;
//	}
	public String getOption_1() {
		return option_1;
	}
	public void setOption_1(String option_1) {
		this.option_1 = option_1;
	}
	public String getOption_2() {
		return option_2;
	}
	public void setOption_2(String option_2) {
		this.option_2 = option_2;
	}
	public String getOption_3() {
		return option_3;
	}
	public void setOption_3(String option_3) {
		this.option_3 = option_3;
	}
	public String getOption_4() {
		return option_4;
	}
	public void setOption_4(String option_4) {
		this.option_4 = option_4;
	}
	public int getLevel_id() {
		return level_id;
	}
	public void setLevel_id(int level_id) {
		this.level_id = level_id;
	}
	
	
}
