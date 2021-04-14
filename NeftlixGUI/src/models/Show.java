package models;

public class Show {

	private String title, rating, ratinglevel, ratingdescription, release_year, user_rating_score;

	public Show(String title, String rating, String ratinglevel, String ratingdescription, String release_year,
			String user_rating_score) {
		this.title = title;
		this.rating = rating;
		this.ratinglevel = ratinglevel;
		this.ratingdescription = ratingdescription;
		this.release_year = release_year;
		this.user_rating_score = user_rating_score;

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getRatinglevel() {
		return ratinglevel;
	}

	public void setRatinglevel(String ratinglevel) {
		this.ratinglevel = ratinglevel;
	}

	public String getRatingdescription() {
		return ratingdescription;
	}

	public void setRatingdescription(String ratingdescription) {
		this.ratingdescription = ratingdescription;
	}

	public String getRelease_year() {
		return release_year;
	}

	public void setRelease_year(String release_year) {
		this.release_year = release_year;
	}

	public String getUser_rating_score() {
		return user_rating_score;
	}

	public void setUser_rating_score(String user_rating_score) {
		this.user_rating_score = user_rating_score;
	}

	@Override
	public String toString() {
		return "Show [title=" + title + ", rating=" + rating + ", ratinglevel=" + ratinglevel + ", ratingdescription="
				+ ratingdescription + ", release_year=" + release_year + ", user_rating_score=" + user_rating_score
				+ ", user_rating_size=";
	}

}
