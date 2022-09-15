package hybrid;

import java.util.Random;
import java.util.Date;

public class Vehicle implements Dashboard {
	private String r_no; // registration no.
	protected static int health;
	protected float weight;
	protected static int battery;
	public static String[] passkey = new String[5];
	public final static String[] types = { "AeroMode", "AquaMode", "NeroMode", "TeraMode" };
	private User user = new User();

	Vehicle() {
		r_no = setrno();
		health = 100;
		weight = 1000; // 1500 kg
		battery = 100;
	}

	public static void setpkeys() {
		System.out.println("Pass keys: ");
		for (int i = 0; i < 5; i++) {
			passkey[i] = new String();
			passkey[i] = java.util.UUID.randomUUID().toString();
			System.out.println(passkey[i] + "\n");
		}
	}

	public static String setrno() {
		Random rand = new Random();
		return Integer.toString(999 + rand.nextInt(9000));
	}

	public String getrno() {
		return r_no;
	}

	public void sethealth() {
		if (Vehicle.health >= 0) {
			Vehicle.health -= 1;
		}
	}

	public void sethealth(int health) {
		Vehicle.health = health;
		if (Vehicle.health >= 100) {
			Vehicle.health = 100;
		}
	}

	public void setweight(float weight) {
		this.weight = weight;
	}

	public boolean checkpasskey(String key) {
		for (String i : passkey) {
			if (i == key) {
				return true;
			}
		}
		return false;
	}

	public String[] getkeys() {
		return passkey;
	}

	public void setbattery(int battery) {
		Vehicle.battery = battery;
		if (Vehicle.battery >= 100) {
			Vehicle.battery = 100;
		} else if (Vehicle.battery < 0) {
			Vehicle.battery = 0;
		}
	}

	public void setbattery() {
		if (Vehicle.battery >= 0) {
			Vehicle.battery -= 0.0001;
		}
	}

	public void displayTime() {
		Date d = new Date();
		System.out.println("Time: " + d.toString());
	}

	public void displayUser() {
		System.out.println("Username: " + user.getUsername());
		System.out.println("User ID: " + user.getUser_id());
	}

	public void displayHealth() {
		System.out.println("Health: " + Vehicle.health);
	}

	public void displayBattery() {
		System.out.println("Battery: " + Vehicle.battery);
	}

	public void displayWeight() {
		System.out.println("Weight: " + weight);
	}

	public static void displayVehiclePrimary() {
		Vehicle vehicle = new Vehicle();
		vehicle.displayUser();
		vehicle.displayTime();

		vehicle.displayHealth();
		vehicle.displayBattery();
		vehicle.displayWeight();
	}

}