package com.example.demo.model;

import java.util.ArrayList;

public class SecondGrafikData {
	
	private String name;
	private ArrayList<Integer> data;
	public SecondGrafikData(String name, ArrayList<Integer> data) {
		super();
		this.name = name;
		this.data = data;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Integer> getData() {
		return data;
	}
	public void setData(ArrayList<Integer> data) {
		this.data = data;
	}
	
	

}
