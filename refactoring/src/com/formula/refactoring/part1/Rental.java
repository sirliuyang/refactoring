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
		return movie.getCharge(daysRented);
	}

	public int getFrequentRenterPoints() {
		int frequentRenterPoints = 0;
		frequentRenterPoints++;

		if ((movie instanceof NewReleaseMovie) && daysRented > 1)
			frequentRenterPoints++;

		return frequentRenterPoints;
	}
}