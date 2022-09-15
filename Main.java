package hybrid;

import java.util.*;

public class Main {

	public static void main(String args[]) {
		int pressure = 1;
		int oxygen = 20;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter driver name:");
		String user = in.next();
		User.setUserName(user);
		Vehicle.setpkeys();
		Vehicle.displayVehiclePrimary();
		boolean flag = true;
		boolean outer = true;

		while (outer) {
			System.out.println("\n~~~Main Menu~~~");
			System.out.println("1.Switch Modes");
			System.out.println("2.Service the vehicle");
			System.out.println("3.Recharge the vehicle");
			System.out.println("4.Reset Odometer");
			System.out.println("5.Turn off vehicle");
			System.out.println("~~~~~~~~~~~~~~~~~");

			int c = in.nextInt();
			if (c == 1){
				System.out.println("\nAvailable Modes: ");
				for(String m: Vehicle.types) {
						System.out.println(m);
					}
				
				System.out.println("\nEnter the Mode to switch to:");
				String mode = in.next();
				flag = true;
				boolean check = false;
				check = Arrays.asList(Vehicle.types).contains(mode);
				if (check) {
					if (mode.equals(Vehicle.types[3])) {
						TeraMode t = new TeraMode();
						t.checkMode();
						if (Mode.current_mode.equals("Tera Mode")) {
							
							while (flag) {
								System.out.println("\n1.Increase Speed");
								System.out.println("2.Decrease Speed");
								System.out.println("3.Change Direction");
								System.out.println("4.Display Dashboard");
								System.out.println("5.Return to main menu");

								int ch;
								ch = in.nextInt();
								if (ch == 1) {
									System.out.println("Enter increment value(1)/ Increment speed by 1(2):");
									int speedc = in.nextInt();
									if (speedc == 1) {
										System.out.println("Enter speed value to be increased:");
										int s = in.nextInt();
										DisplayGauge.increaseSpeed(s);
									} else
										DisplayGauge.increaseSpeed();
								} else if (ch == 2) {
									System.out.println("Enter decrement value(1)/ Decrement speed by 1(2):");
									int speedc = in.nextInt();
									if (speedc == 1) {
										System.out.println("Enter speed value to be decreased:");

										int s = in.nextInt();

										DisplayGauge.decreaseSpeed(s);

									} else
										DisplayGauge.decreaseSpeed();

								} else if (ch == 3) {
									System.out.println("Enter the change in direction(degrees):");
									float deg = in.nextInt();
									float value = GPS.getDegree() + deg;
									GPS.setDegree(value);

								} else if (ch == 4) {
									System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
									t.displayTera();
									System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
								} else if (ch == 5) {
									flag = false;
								}
							}

						}
					}
					if (mode.equals(Vehicle.types[1])) {
						AquaMode aq = new AquaMode(pressure,oxygen);
						aq.checkMode();
						if (Mode.current_mode.equals("Aqua Mode")) {
							while (flag) {
								System.out.println("\n1.Increase Speed");
								System.out.println("2.Decrease Speed");
								System.out.println("3.Change Direction");
								System.out.println("4.Change depth");
								System.out.println("5.Display Dashboard");
								System.out.println("6.Return to main menu");

								int ch;
								ch = in.nextInt();
								if (ch == 1) {
									System.out.println("Enter increment value(1)/ Increment speed by 1(2):");
									int speedc = in.nextInt();
									if (speedc == 1) {
										System.out.println("Enter speed value to be increased:");
										int s = in.nextInt();
										DisplayGauge.increaseSpeed(s);
									} else
										DisplayGauge.increaseSpeed();
								} else if (ch == 2) {
									System.out.println("Enter decrement value(1)/ Decrement speed by 1(2):");
									int speedc = in.nextInt();
									if (speedc == 1) {
										System.out.println("Enter speed value to be decreased:");

										int s = in.nextInt();

										DisplayGauge.decreaseSpeed(s);

									} else
										DisplayGauge.decreaseSpeed();

								} else if (ch == 3) {
									System.out.println("Enter the change in direction(degrees):");
									float deg = in.nextInt();
									float value = GPS.getDegree() + deg;
									GPS.setDegree(value);

								} else if (ch == 4) {

									System.out.println("Enter depth to be Changed:");
									int d = in.nextInt();
									aq.setDepth(d);
								} else if (ch == 5) {
									System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
									aq.displayAqua();
									System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
								} else if (ch == 6) {
									flag = false;
								}
							}
						}
					} else if (mode.equals(Vehicle.types[0])) {
						AeroMode a = new AeroMode(pressure,oxygen);
						a.checkMode();
						while (flag) {
							if (Mode.current_mode.equals("Aero Mode")) {
								System.out.println("\n1.Increase Speed");
								System.out.println("2.Decrease Speed");
								System.out.println("3.Change Direction");
								System.out.println("4.Change Altitude");
								System.out.println("5.Display Dashboard");
								System.out.println("6.Return to main menu");
								int ch;
								ch = in.nextInt();
								if (ch == 1) {
									System.out.println("Enter increment value(1)/ Increment speed by 1(2):");
									int speedc = in.nextInt();
									if (speedc == 1) {
										System.out.println("Enter speed value to be increased:");
										int s = in.nextInt();
										DisplayGauge.increaseSpeed(s);
									} else
										DisplayGauge.increaseSpeed();
								} else if (ch == 2) {
									System.out.println("Enter decrement value(1)/ Decrement speed by 1(2):");
									int speedc = in.nextInt();
									if (speedc == 1) {
										System.out.println("Enter speed value to be decreased:");
										int s = in.nextInt();
										DisplayGauge.decreaseSpeed(s);
									} else
										DisplayGauge.decreaseSpeed();
								} else if (ch == 3) {
									System.out.println("Enter the change in direction(degrees):");
									float deg = in.nextInt();
									float value = GPS.getDegree() + deg;
									GPS.setDegree(value);
								} else if (ch == 4) {
									System.out.println("Enter altitude to be Changed:");
									int alt = in.nextInt();
									a.setAlt(alt);
								} else if (ch == 5) {
									System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
									a.displayAero();
									System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
								} else if (ch == 6) {
									flag = false;
								}
							}
						}
					} else if (mode.equals(Vehicle.types[2])) {
						NeroMode n = new NeroMode(pressure);
						n.checkMode();
						if (Mode.current_mode.equals("Nero Mode")) {
							while (flag) {
								System.out.println("\n1.Increase Speed");
								System.out.println("2.Decrease Speed");
								System.out.println("3.Change Direction");
								System.out.println("4.Display Dashboard");
								System.out.println("5.Return to main menu");
								int ch;
								ch = in.nextInt();
								if (ch == 1) {
									System.out.println("Enter increment value(1)/ Increment speed by 1(2):");
									int speedc = in.nextInt();
									if (speedc == 1) {
										System.out.println("Enter speed value to be increased:");
										int s = in.nextInt();
										DisplayGauge.increaseSpeed(s);
									} else
										DisplayGauge.increaseSpeed();
								} else if (ch == 2) {
									System.out.println("Enter decrement value(1)/ Decrement speed by 1(2):");
									int speedc = in.nextInt();
									if (speedc == 1) {
										System.out.println("Enter speed value to be decreased:");

										int s = in.nextInt();

										DisplayGauge.decreaseSpeed(s);

									} else
										DisplayGauge.decreaseSpeed();

								} else if (ch == 3) {
									System.out.println("Enter the change in direction(degrees):");
									float deg = in.nextInt();
									float value = GPS.getDegree() + deg;
									GPS.setDegree(value);

								} else if (ch == 4) {
									System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
									n.displayNero();
									System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
								} else if (ch == 5) {
									flag = false;
								}
							}

						}
					}
				}
					else {
						System.out.println("Invalid Mode!");
					}
				

			} else if (c == 2) {
				if (Mode.current_mode.equals("Tera Mode")) {
					ServiceCenter sc = new ServiceCenter();
					sc.DispServices();
				}
			} else if (c == 3) {
				if (Mode.current_mode.equals("Tera Mode")) {
					ChargingStation CS = new ChargingStation();
					CS.chargeVehicle();
					CS.dispCharging();
				}
			} else if (c == 4) {
				DisplayGauge.resetOdometer();
				System.out.println("Odometer reset!");
			} else if (c == 5) {
				outer = false;
			}
		}
        in.close();
	}
}