package hybrid;

public class TeraMode extends Mode {
	private DisplayGauge DispG;

	public TeraMode() {
		health_limit = 50;
		battery_limit = 50;
		maximum_weight = 3000;
	}

	public void checkMode() {
		if (health >= getHealthLimit() && battery >= getBatteryLimit() && weight <= getMaximumWeight()) {
			updateMode("Tera Mode");
		} else {
			giveWarning("Tera Mode");

		}

	}

	public void displayTera() {
		DispG = new DisplayGauge();
		System.out.println("Current Mode: " + current_mode);
		this.DispG.display();
	}

}