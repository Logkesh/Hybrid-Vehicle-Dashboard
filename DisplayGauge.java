package hybrid;


public class DisplayGauge {
	private static int current_distance = 0;
	private static float speed = 0;
	private static float rpm = 0;
	private static int miles = 0;
	static GPS g = new GPS();

	public void display() {
		Vehicle.displayVehiclePrimary();
		System.out.println("Speedometer: " + speed + "m/s");
		System.out.println("Odometer: Current Distance: " + current_distance + " Total Distance: " + miles);
		System.out.println("Tachometer: " + rpm + "rpm");
		g.showGPS();
	}

	public static void increaseSpeed() {
		speed += 1;
		updateOdometer();
		updateTachometer();
	}

	public static void increaseSpeed(int inc) {
		speed += inc;
		updateOdometer();
		updateTachometer();
	}

	public static void decreaseSpeed() {
		speed -= 1;
		updateOdometer();
		updateTachometer();
	}

	public static void decreaseSpeed(int dec) {
		speed -= dec;
		updateOdometer();
		updateTachometer();
	}

	public static void resetOdometer() {
		current_distance = 0;
		updateOdometer();
		updateTachometer();
	}

	public static void updateOdometer() {

		current_distance += (Math.abs(speed));
		miles += Math.abs(speed);
		g.updateLatLon(speed);
		/*
		 * try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) {
		 * System.out.print("can't sleep give me a tablet"); }
		 */

	}

	public static void updateTachometer() {

		rpm += 90 * 60 * Math.abs(speed);
		/*
		 * try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) {
		 * System.out.print("can't sleep give me a tablet"); }
		 */

	}
}
