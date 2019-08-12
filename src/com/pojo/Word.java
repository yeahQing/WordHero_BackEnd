package com.pojo;

public class Word {
	private int word_id;
	private String word_name;
	private String word_translate;
	
	public Word() {}
	
	public Word(int word_id,String word_name,String word_translate) {
		this.word_id = word_id;
		this.word_name = word_name;
		this.word_translate = word_translate;
	}
	
	public int getWord_id() {
		return word_id;
	}
	public void setWord_id(int word_id) {
		this.word_id = word_id;
	}
	public String getWord_name() {
		return word_name;
	}
	public void setWord_name(String word_name) {
		this.word_name = word_name;
	}
	public String getWord_translate() {
		return word_translate;
	}
	public void setWord_translate(String word_translate) {
		this.word_translate = word_translate;
	}
	
	
}
