package hybrid;

public class AquaMode extends Mode {
	private int pressure;
	private int temperature;
	private int oxygen;
	private DisplayGauge DispG = new DisplayGauge();
	private DepthGauge DepG = new DepthGauge();

	public AquaMode() {
		setHealthLimit(80);
		setBatteryLimit(80);
		setMaximumWeight(1300);
		setOxygenLimit(30);
		setTempLimit(87);
		setPressureLimit(2);
		this.temperature = 92;
	}
	
	public void setDepth(int dep) {
		if(1/pressure < getPressureLimit() + 4) DepG.incrementdepth(dep);
		else System.out.println("Can't Increase the Depth, Else death confirm :)");
	}
	
	public AquaMode(int Pressure, int oxygen)
	{
	this();
	this.pressure = Pressure;
	this.oxygen = oxygen;
	}

	public void checkMode() {
		if (health >= getHealthLimit() && battery >= getBatteryLimit() && weight <= getMaximumWeight()
				&& oxygen < getOxygenLimit() && temperature > getTempLimit() && pressure < getPressureLimit()) {
			updateMode("Aqua Mode");
		} else {
			giveWarning("Aqua Mode");

		}
	}

	public void displayAqua() {
		System.out.println("Current Mode: " + current_mode);
		this.DispG.display();
		this.DepG.displayDepth();
	}

	
}