package com.example.model;

public class Team {

	private String name;
	private Integer GF;
	private Integer GC;
	
	public Team() {
	}

	public Team(String name, Integer GF, Integer GC) {
		super();
		this.name = name;
		this.GF = GF;
		this.GC = GC;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGF() {
		return this.GF;
	}

	public void setGF(Integer GF) {
		this.GF = GF;
	}

	public Integer getGC() {
		return this.GC;
	}

	public void setGC(Integer GC) {
		this.GC = GC;
	}

}
