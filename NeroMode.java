package hybrid;

public class NeroMode extends Mode {
	private int pressure;
	private DisplayGauge DispG = new DisplayGauge();

	public NeroMode() {
		health_limit = 70;
		battery_limit = 70;
		maximum_weight = 4000;
		pressure_limit = 5;
	}
	public NeroMode(int Pressure)
	{
	this();
	this.pressure = Pressure;
	}
	public void checkMode() {
		if (health >= getHealthLimit() && battery >= getBatteryLimit() && weight <= getMaximumWeight()
				&& pressure < getPressureLimit()) {
			updateMode("Nero Mode");
		} else {
			giveWarning("Nero Mode");
		}

	}

	public int getPressure() {
		return pressure;
	}

	public void setPressure(int pressure) {
		this.pressure = pressure;
	}

	public void displayNero() {
		System.out.println("Current Mode: " + current_mode);
		this.DispG.display();
	}

}