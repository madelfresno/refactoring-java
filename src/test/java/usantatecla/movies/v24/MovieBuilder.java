package usantatecla.movies.v24;

public class MovieBuilder {

	private String title;
	private Movie movie;
	
	public MovieBuilder() {
		title = "movieName";
	}
	
	public MovieBuilder title(String title) {
		this.title = title;
		return this;
	}
	
	public MovieBuilder childrens() {
		this.movie = new ChildrenMovie(this.title);
		return this;
	}
	
	public MovieBuilder regular() {
		this.movie = new RegularMovie(this.title);
		return this;
	}
	
	public MovieBuilder newRelease() {
		this.movie = new NewReleaseMovie(this.title);
		return this;
	}
	
	public Movie build() {
		return movie;
	}
}
