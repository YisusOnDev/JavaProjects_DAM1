package models;

public class Weather {
	String month;
	double maxT, minT, rainyDays;

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
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * @return the maxT
	 */
	public double getMaxT() {
		return maxT;
	}

	/**
	 * @param maxT the maxT to set
	 */
	public void setMaxT(double maxT) {
		this.maxT = maxT;
	}

	/**
	 * @return the minT
	 */
	public double getMinT() {
		return minT;
	}

	/**
	 * @param minT the minT to set
	 */
	public void setMinT(double minT) {
		this.minT = minT;
	}

	/**
	 * @return the rainyDays
	 */
	public double getRainyDays() {
		return rainyDays;
	}

	/**
	 * @param rainyDays the rainyDays to set
	 */
	public void setRainyDays(double rainyDays) {
		this.rainyDays = rainyDays;
	}

	@Override
	public String toString() {
		return "Weather [month=" + month + ", maxT=" + maxT + ", minT=" + minT + ", rainyDays=" + rainyDays + "]";
	}

}
