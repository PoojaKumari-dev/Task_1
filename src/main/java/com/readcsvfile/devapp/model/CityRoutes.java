package com.readcsvfile.devapp.model;

public class CityRoutes {

	private String city1;
	private String city2;
	private String city3;
	private int mint;
	private int seasonal;

	public CityRoutes() {
		super();
	}

	public CityRoutes(String city1, String city2, String city3, int mint, int seasonal) {
		super();
		this.city1 = city1;
		this.city2 = city2;
		this.city3 = city3;
		this.mint = mint;
		this.seasonal = seasonal;
	}

	public String getCity1() {
		return city1;
	}

	public void setCity1(String city1) {
		this.city1 = city1;
	}

	public String getCity2() {
		return city2;
	}

	public void setCity2(String city2) {
		this.city2 = city2;
	}

	public String getCity3() {
		return city3;
	}

	public void setCity3(String city3) {
		this.city3 = city3;
	}

	public int getMint() {
		return mint;
	}

	public void setMint(int mint) {
		this.mint = mint;
	}

	public int getSeasonal() {
		return seasonal;
	}

	public void setSeasonal(int seasonal) {
		this.seasonal = seasonal;
	}

}
