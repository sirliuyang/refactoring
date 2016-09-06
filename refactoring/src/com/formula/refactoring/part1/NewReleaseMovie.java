package com.formula.refactoring.part1;

public class NewReleaseMovie implements Movie{

	private String title;
	
	public NewReleaseMovie(String title){
		this.title = title;
	}

	@Override
	public String getTitle() {
		return title;
	}


	@Override
	public double getCharge(int daysRented) {
		return daysRented * 3;
	}

}
