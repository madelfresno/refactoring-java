package usantatecla.movies.v24;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerTest {

	@Test
	public void statementWithoutRentalsTest() {
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName)
				.totalAmount(0).frequentRenterPoints(0).build();
		assertEquals(result, statement);
	}

	@Test
	public void statementRegularRental1DayTest() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).regular().build();
		Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 2)
				.totalAmount(2).frequentRenterPoints(1).build();
		assertEquals(result, statement);
	}
	
	@Test
	public void statementRegularRental2DayTest() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).regular().build();
		Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 2)
				.totalAmount(2).frequentRenterPoints(1).build();
		assertEquals(result, statement);
	}

	@Test
	public void statementRegularRental3DayTest() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).regular().build();
		Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 3.5)
				.totalAmount(3.5).frequentRenterPoints(1).build();
		assertEquals(result, statement);
	}
	
	@Test
	public void statementNewReleaseRental1DayTest() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).newRelease().build();
		Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 3)
				.totalAmount(3).frequentRenterPoints(1).build();
		assertEquals(result, statement);
	}
	
	@Test
	public void statementNewReleaseRental2DayTest() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).newRelease().build();
		Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 3)
				.totalAmount(3).frequentRenterPoints(2).build();
		assertEquals(result, statement);
	}
	
	@Test
	public void statementNewReleaseRental3DayTest() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).newRelease().build();
		Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 3)
				.totalAmount(3).frequentRenterPoints(2).build();
		assertEquals(result, statement);
	}
	
	@Test
	public void statementChildrensRental1DayTest() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).childrens().build();
		Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 1.5)
				.totalAmount(1.5).frequentRenterPoints(1).build();
		assertEquals(result, statement);
	}
	
	@Test
	public void statementChildrensRental3DayTest() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).childrens().build();
		Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 1.5)
				.totalAmount(1.5).frequentRenterPoints(1).build();
		assertEquals(result, statement);
	}
	
	@Test
	public void statementChildrensRental4DayTest() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).childrens().build();
		Rental rental = new RentalBuilder().movie(movie).daysRented(4).build();
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 6)
				.totalAmount(6).frequentRenterPoints(1).build();
		assertEquals(result, statement);
	}
	
	@Test
	public void statementRentalTest() {
		String regularMovieName = "regularMovieName";
		Movie regularMovie = new MovieBuilder().title(regularMovieName).regular().build();
		Rental regularRental = new RentalBuilder().movie(regularMovie).daysRented(10).build();
		
		String newReleaseMovieName = "newReleaseMovieName";
		Movie newReleaseMovie = new MovieBuilder().title(newReleaseMovieName).newRelease().build();
		Rental newReleaseRental = new RentalBuilder().movie(newReleaseMovie).daysRented(10).build();
		
		String childrensMovieName = "childrensMovieName";
		Movie childrensMovie = new MovieBuilder().title(childrensMovieName).childrens().build();
		Rental childrensRental = new RentalBuilder().movie(childrensMovie).daysRented(10).build();
		
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName)
				.rental(regularRental).rental(newReleaseRental).rental(childrensRental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName)
				.movie(regularMovieName, 14).movie(newReleaseMovieName, 3).movie(childrensMovieName, 15)
				.totalAmount(32).frequentRenterPoints(4).build();
		assertEquals(result, statement);
	}
	
	@Test
	public void totalChargeRegularRentalZeroDaysTest() {
		Movie regularMovie = new MovieBuilder().title("regular").regular().build();
		assertEquals(2.0, regularMovie.getCharge(0), 0.01);	
	}
	
	@Test
	public void totalChargeRegularRentalThreeDaysTest() {
		Movie regularMovie = new MovieBuilder().title("regular").regular().build();
		assertEquals(3.5, regularMovie.getCharge(3), 0.01);	
	}
	
	@Test
	public void totalChargeChildrenRentalZeroDaysTest() {
		Movie childrenMovie = new MovieBuilder().title("children").childrens().build();
		assertEquals(1.5, childrenMovie.getCharge(0), 0.01);	
	}
	
	@Test
	public void totalChargeChildrenRentalFourDaysTest() {
		Movie childrenMovie = new MovieBuilder().title("children").childrens().build();
		assertEquals(6.0, childrenMovie.getCharge(4), 0.01);	
	}
	
	@Test
	public void totalChargeNewReleaseRentalZeroDaysTest() {
		Movie newReleaseMovie = new MovieBuilder().title("newRelease").newRelease().build();
		assertEquals(3.0, newReleaseMovie.getCharge(0), 0.01);	
	}
	
	@Test
	public void totalChargeNewReleaseRentalFourDaysTest() {
		Movie newReleaseMovie = new MovieBuilder().title("newRelease").newRelease().build();
		assertEquals(3.0, newReleaseMovie.getCharge(4), 0.01);	
	}
	
	@Test
	public void totalFrequentRenterPointsRegularRentalZeroDaysTest() {
		Movie regularMovie = new MovieBuilder().title("regular").regular().build();
		assertEquals(1, regularMovie.getFrequentRenterPoints(0));
	}
	
	@Test
	public void totalFrequentRenterPointsRegularRentalThreeDaysTest() {
		Movie regularMovie = new MovieBuilder().title("regular").regular().build();
		assertEquals(1, regularMovie.getFrequentRenterPoints(3));
	}
	
	@Test
	public void totalFrequentRenterPointsChildrenRentalZeroDaysTest() {
		Movie childrenMovie = new MovieBuilder().title("children").childrens().build();
		assertEquals(1, childrenMovie.getFrequentRenterPoints(0));
	}
	
	@Test
	public void totalFrequentRenterPointsChildrenRentalThreeDaysTest() {
		Movie childrenMovie = new MovieBuilder().title("children").childrens().build();
		assertEquals(1, childrenMovie.getFrequentRenterPoints(3));
	}
	
	@Test
	public void totalFrequentRenterPointsNewReleaseRentalZeroDaysTest() {
		Movie newReleaseMovie = new MovieBuilder().title("newRelease").newRelease().build();
		assertEquals(1, newReleaseMovie.getFrequentRenterPoints(0));
	}
	
	@Test
	public void totalFrequentRenterPointsNewReleaseRentalThreeDaysTest() {
		Movie newReleaseMovie = new MovieBuilder().title("newRelease").newRelease().build();
		assertEquals(2, newReleaseMovie.getFrequentRenterPoints(3));
	}
}
