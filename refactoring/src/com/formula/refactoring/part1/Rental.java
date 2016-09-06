package com.formula.refactoring.part1;

import java.util.Iterator;

public class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public double getCharge() {
		double eachAmount = 0;
		switch (movie.getPriceCode()) {
		case Movie.REGULAR:
			eachAmount += 2;
			if (daysRented > 2) {
				eachAmount += (daysRented - 2) * 1.5;
			}
			break;
		case Movie.CHILDRENS:
			eachAmount += 1.5;
			if (daysRented > 3) {
				eachAmount += (daysRented - 3) * 1.5;
				break;
			}
		case Movie.NEW_RELEASE:
			eachAmount += daysRented * 3;
			break;
		}
		return eachAmount;
	}
	
	public int getFrequentRenterPoints(){
		int frequentRenterPoints = 0;
		frequentRenterPoints++;

		if ((movie.getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1)
			frequentRenterPoints++;
		
		return frequentRenterPoints;
	}
}