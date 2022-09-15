package hybrid;

import java.util.Arrays;
import java.util.Scanner;

public class ServiceCenter {
	public void increaseHealth() {
		Vehicle.health = 100;
	}

	public void DispServices() {
		System.out.println("Enter passkey:");
		Scanner in = new Scanner(System.in);
		String c = in.next();
		boolean test = Arrays.asList(Vehicle.passkey).contains(c);
		if (test) {
			increaseHealth();
			System.out.println("Health updated!\n");
		} else {
			System.out.println("Not Authorised!");
		}
	}
}