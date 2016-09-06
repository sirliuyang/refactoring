package com.formula.refactoring.part1;

public class ChildrensMovie implements Movie {
	
	private String title;
	
	public ChildrensMovie(String title){
		this.title = title;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public double getCharge(int daysRented) {
		if (daysRented > 3) {
			return 1.5 + (daysRented - 3) * 1.5;
		} else {
			return 1.5;
		}
	}

}
