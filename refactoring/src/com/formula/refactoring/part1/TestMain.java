package com.formula.refactoring.part1;

public class TestMain {
	public static void main(String[] args) {
		Movie movie = new RegularMovie("Inception");
		Rental rental = new Rental(movie, 5);
		Customer customer = new Customer("Leon");
		customer.addRental(rental);
		System.out.println(customer.statement());
	}
}
