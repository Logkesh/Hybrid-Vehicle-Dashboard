package hybrid;

public class Altimeter {
	private int altitude=0;

	public void setaltitude(int altitude) {
		this.altitude = altitude;
	}

	public int getaltitude() {
		return altitude;
	}

	public void incrementalt() {
		altitude = altitude + 5;
	}

	public void decrementalt() {
		altitude = altitude - 5;
	}
	
	public void incrementalt(int inc) {
		altitude = altitude + inc;
	}
	
	public void decrementalt(int dec) {
		altitude = altitude - dec;
	}

	public void displayAltitude() {
		System.out.println("Altitude: " + altitude + " m");
	}

}