package hybrid;

public class ChargingStation {
	public void chargeVehicle() {
		Vehicle.battery = 100;
	}

	public void dispCharging() {
		System.out.println("Vehicle successfully charged!");
	}
}