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
			Rental eachRental = (Rental) iteratorRentals.next();
			frequentRenterPoints = eachRental.getFrequentRenterPoints();

			result += "\t" + eachRental.getMovie().getTitle() + "\t" + String.valueOf(eachRental.getCharge()) + "\n";
			totalAmount += eachRental.getCharge();
		}

		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequentRenterPoints";

		return result;
	}

}
