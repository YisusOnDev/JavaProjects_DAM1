package models;

public class Weather {
	String month;
	double maxT, minT, rainyDays;

	/**
	 * Constructor for create a weather line info
	 * 
	 * @param month     the month
	 * @param maxT      maximum temperature
	 * @param minT      minimum temperature
	 * @param rainyDays count(rainy days) of the month
	 */
	public Weather(String month, double maxT, double minT, double rainyDays) {
		super();
		this.month = month;
		this.maxT = maxT;
		this.minT = minT;
		this.rainyDays = rainyDays;
	}

	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * @return the max temperature
	 */
	public double getMaxT() {
		return maxT;
	}

	/**
	 * @return the min temperature
	 */
	public double getMinT() {
		return minT;
	}

	/**
	 * @return the rainyDays
	 */
	public double getRainyDays() {
		return rainyDays;
	}

	@Override
	public String toString() {
		return "Weather [month=" + month + ", maxT=" + maxT + ", minT=" + minT + ", rainyDays=" + rainyDays + "]";
	}

}
