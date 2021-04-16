package models;

public class Show {
	private String title, rating, ratinglevel, ratingdescription, release_year, user_rating_score, user_rating_size;
	private boolean isFavourite;

	/**
	 * Constructor for Show without isFavourite flag
	 * 
	 * @param title             String
	 * @param rating            String
	 * @param ratinglevel       String
	 * @param ratingdescription String
	 * @param release_year      String
	 * @param user_rating_score String
	 * @param user_rating_size  String
	 */
	public Show(String title, String rating, String ratinglevel, String ratingdescription, String release_year,
			String user_rating_score, String user_rating_size) {
		this.title = title;
		this.rating = rating;
		this.ratinglevel = ratinglevel;
		this.ratingdescription = ratingdescription;
		this.release_year = release_year;
		this.user_rating_score = user_rating_score;
		this.user_rating_size = user_rating_size;
		this.isFavourite = false;

	}

	/**
	 * Constructor for Show with isFavourite flag
	 * 
	 * @param title             String
	 * @param rating            String
	 * @param ratinglevel       String
	 * @param ratingdescription String
	 * @param release_year      String
	 * @param user_rating_score String
	 * @param user_rating_size  String
	 * @param isFavourite       Boolean
	 */
	public Show(String title, String rating, String ratinglevel, String ratingdescription, String release_year,
			String user_rating_score, String user_rating_size, boolean isFavourite) {
		this.title = title;
		this.rating = rating;
		this.ratinglevel = ratinglevel;
		this.ratingdescription = ratingdescription;
		this.release_year = release_year;
		this.user_rating_score = user_rating_score;
		this.user_rating_size = user_rating_size;
		this.isFavourite = isFavourite;

	}

	

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}

	/**
	 * @return the ratinglevel
	 */
	public String getRatinglevel() {
		return ratinglevel;
	}

	/**
	 * @param ratinglevel the ratinglevel to set
	 */
	public void setRatinglevel(String ratinglevel) {
		this.ratinglevel = ratinglevel;
	}

	/**
	 * @return the ratingdescription
	 */
	public String getRatingdescription() {
		return ratingdescription;
	}

	/**
	 * @param ratingdescription the ratingdescription to set
	 */
	public void setRatingdescription(String ratingdescription) {
		this.ratingdescription = ratingdescription;
	}

	/**
	 * @return the release_year
	 */
	public String getRelease_year() {
		return release_year;
	}

	/**
	 * @param release_year the release_year to set
	 */
	public void setRelease_year(String release_year) {
		this.release_year = release_year;
	}

	/**
	 * @return the user_rating_score
	 */
	public String getUser_rating_score() {
		return user_rating_score;
	}

	/**
	 * @param user_rating_score the user_rating_score to set
	 */
	public void setUser_rating_score(String user_rating_score) {
		this.user_rating_score = user_rating_score;
	}

	/**
	 * @return the user_rating_size
	 */
	public String getUser_rating_size() {
		return user_rating_size;
	}

	/**
	 * @param user_rating_size the user_rating_size to set
	 */
	public void setUser_rating_size(String user_rating_size) {
		this.user_rating_size = user_rating_size;
	}

	/**
	 * @return the isFavourite
	 */
	public boolean isFavourite() {
		return isFavourite;
	}

	/**
	 * @param isFavourite the isFavourite to set
	 */
	public void setFavourite(boolean isFavourite) {
		this.isFavourite = isFavourite;
	}

	@Override
	public String toString() {
		return "Show [title=" + title + ", rating=" + rating + ", ratinglevel=" + ratinglevel + ", ratingdescription="
				+ ratingdescription + ", release_year=" + release_year + ", user_rating_score=" + user_rating_score
				+ ", user_rating_size=";
	}

}
