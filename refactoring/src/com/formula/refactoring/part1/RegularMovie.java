package com.formula.refactoring.part1;

public class RegularMovie implements Movie {
	
	private String title;

	public RegularMovie(String title) {
		this.title = title;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public double getCharge(int daysRented) {
		if (daysRented > 2) {
			return 2 + (daysRented - 2) * 1.5;
		} else {
			return 2;
		}
	}
}
