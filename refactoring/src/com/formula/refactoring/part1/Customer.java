package com.formula.refactoring.part1;

import java.util.Iterator;
import java.util.Vector;

public class Customer {
	private String name;
	private Vector rentals = new Vector();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		this.rentals.addElement(arg);
	}

	public String getName() {
		return this.name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator iteratorRentals = rentals.iterator();
		String result = "Rental Record for " + getName() + "\n";
		while (iteratorRentals.hasNext()) {
			Rental each = (Rental) iteratorRentals.next();
			double thisAmount = amountFor(each);
			frequentRenterPoints++;

			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
				frequentRenterPoints++;

			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}

		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequentRenterPoints";

		return result;
	}

	private double amountFor(Rental each) {
		double thisAmount = 0;
		switch (each.getMovie().getPriceCode()) {
		case Movie.REGULAR:
			thisAmount += 2;
			if (each.getDaysRented() > 2) {
				thisAmount += (each.getDaysRented() - 2) * 1.5;
			}
			break;
		case Movie.CHILDRENS:
			thisAmount += 1.5;
			if (each.getDaysRented() > 3) {
				thisAmount += (each.getDaysRented() - 3) * 1.5;
				break;
			}
		case Movie.NEW_RELEASE:
			thisAmount += each.getDaysRented() * 3;
			break;
		}
		return thisAmount;
	}

}
