package com.optmx.puzzle;

public class Fruit {
	public Fruit(String name){
		setName( name);
	}
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String toString(){
		return name;
	}

}
