package hybrid;

abstract class Mode extends Vehicle {
	public static String current_mode="Tera Mode";
	int health_limit;
	int battery_limit;
	int maximum_weight;
	int temp_limit;
	int speed_limit;
	int pressure_limit;
	float oxygen_limit;

	public abstract void checkMode();

	public void giveWarning(String mode) {
		System.out.println("Cannot convert to " + mode + " !");
	}

	public static void updateMode(String mode) {
		current_mode = mode;
	}

	public int getPressureLimit() {
		return pressure_limit;
	}

	public void setPressureLimit(int pressure) {
		this.pressure_limit = pressure;
	}

	public float getOxygenLimit() {
		return oxygen_limit;
	}

	public void setOxygenLimit(int oxygen) {
		this.oxygen_limit = oxygen;
	}

	public int getMaximumWeight() {
		return this.maximum_weight;
	}

	public void setMaximumWeight(int weight) {
		this.maximum_weight = weight;
	}

	public int getTempLimit() {
		return temp_limit;
	}


	public void setTempLimit(int temp_limit) {
		this.temp_limit = temp_limit;
	}

	public int getBatteryLimit() {
		return battery_limit;
	}

	public void setBatteryLimit(int battery) {
		this.battery_limit = battery;
	}

	public void setSpeedLimit(int speed) {
		this.speed_limit = speed;
	}

	public int getSpeedLimit() {
		return speed_limit;
	}

	public int getHealthLimit() {
		return health_limit;
	}

	public void setHealthLimit(int health) {
		this.health_limit = health;
	}

}