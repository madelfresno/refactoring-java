package usantatecla.movies.v23;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;

public class Customer {

	private String name;
	
	private List<Rental> rentals;

	public Customer(String name) {
		this.name = name;
		rentals = new ArrayList<Rental>();
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		Iterator<Rental> rentals = this.rentals.iterator();
		String result = "Rental Record for " + this.getName() + "\n";
		while (rentals.hasNext()) {
			Rental each = rentals.next();
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
		}
		result += "Amount owed is " + String.valueOf(this.getTotal(Rental::getCharge)) + "\n";
		result += "You earned " + String.valueOf((int)this.getTotal(Rental::getFrequentRenterPoints)) + " frequent renter points";
		return result;
	}
	
	private <T extends Number> double getTotal(Function<Rental, T> function) {
		return rentals
				.stream()
				.map(function)
				.mapToDouble(Number::doubleValue)
				.sum();
	}
}
