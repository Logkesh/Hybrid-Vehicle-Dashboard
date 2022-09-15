package hybrid;

public class AeroMode extends Mode {
	private float pressure;
	private float oxygen;
	private DisplayGauge DispG = new DisplayGauge();
	private Altimeter Alt = new Altimeter();

	public AeroMode() {
		setHealthLimit(80);
		setBatteryLimit(80);
		setMaximumWeight(1700);
		setOxygenLimit(30);
		setTempLimit(87);
		setPressureLimit(1);
		
	}
	
	public AeroMode(int Pressure, int oxygen)
	{
	this();
	this.pressure = Pressure;
	this.oxygen = oxygen;
	}

	public void checkMode() {

		if (health >= getHealthLimit() && battery >= getBatteryLimit() && weight <= getMaximumWeight()
				&& oxygen < getOxygenLimit()) {
			updateMode("Aero Mode");
		} else {
			giveWarning("Aero Mode");
		}

	}

	public void displayAero() {
		System.out.println("Current Mode: " + current_mode);
		this.DispG.display();
		this.Alt.displayAltitude();
	}

	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
		if(this.pressure < 0) {
			this.pressure = (float) 0.1;
		}
	}

	public Altimeter getAlt() {
		return Alt;
	}

	public void setAlt(int alt) {
		if(1/pressure < getPressureLimit() + 4) Alt.incrementalt(alt);
		else System.out.println("Can't Increase the Altitude, Else death confirm :)");
	}

	public DisplayGauge getDispG() {
		return DispG;
	}

	public void setDispG(DisplayGauge dispG) {
		this.DispG = dispG;
	}
}