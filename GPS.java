package hybrid;

public class GPS {
	private static float latitude = 0;
	private static float longitude = 0;
	private static float degree = 0;
	private static String direction_of_travel = "North";
	private static float[][] obstacle_course = new float[19*37][2];

	public GPS() {
		for (int i = 0; i < 18*36; i++) {
			obstacle_course[i] = new float[2];
		}

		for (int i = 0; i <= 36; i++) {
			for (int j = 0; j <= 18; j++) {
				obstacle_course[36*(j) + (i)][0] = (float) (i-18) * 10; // Longitude
				obstacle_course[36*(j) + (i)][1] = (float) (j-9) * 10; // Lattitude
			}
		}
	}

	public static float getDegree() {
		return GPS.degree;
	}

	public static void setDegree(float deg) {
		GPS.degree = deg;
		if (GPS.degree > 360 || GPS.degree < 0) {
			GPS.degree = GPS.degree % 360;
		}
		GPS.setDirection();
	}

	public static String getDirection() {
		return GPS.direction_of_travel;
	}

	public static void setDirection() {
		// 360 degree notation with absolute north at 0 degrees
		if ((GPS.degree <= 45 && GPS.degree >= 0) || (GPS.degree < 360 && GPS.degree > 315)) {
			GPS.direction_of_travel = "North";
		} else if (degree > 45 && degree <= 135) {
			GPS.direction_of_travel = "East";
		} else if (degree > 135 && degree <= 225) {
			GPS.direction_of_travel = "South";
		} else if (degree < 225 && degree <= 315) {
			GPS.direction_of_travel = "West";
		} else {
			direction_of_travel = "Invalid";
		}
	}

	private static float getDistance(float a, float b) {
		return (float) Math.sqrt(Math.pow((latitude - a), 2) + Math.pow((longitude - b), 2));
	}

	public void updateLatLon(float speed) {		
		float sinComp = (float) Math.sin((double) GPS.degree);
		float cosComp = (float) Math.cos((double) GPS.degree);

		longitude += -0.0000089 * speed * sinComp;
		latitude += 2 * 0.0000089 * speed * cosComp;

		checkRadar();
	}

	private static void checkRadar() {
		for (int i = 0; i < obstacle_course.length-18; i++) {
			
			float dist = getDistance(obstacle_course[i][0], obstacle_course[i][1]);
			if (Mode.current_mode.equals("Tera Mode")) {
				if (dist < 0.0001) {
					showWarning(dist, obstacle_course[i][0], obstacle_course[i][1]);
				}
			}
			else if (Mode.current_mode.equals("Aqua Mode")) {
				if (dist < 0.01) {
					showWarning(dist, obstacle_course[i][0], obstacle_course[i][1]);
				}
			}
			else if (Mode.current_mode.equals("Nero Mode")) {
				if (dist < 0.1) {
					showWarning(dist, obstacle_course[i][0], obstacle_course[i][1]);
				}
			}
			else if (Mode.current_mode.equals("Aero Mode")) {
				if (dist < 1) {
					showWarning(dist, obstacle_course[i][0], obstacle_course[i][1]);
				}
			}
		}
	}

	private static void showWarning(float dist, float a, float b) {
		System.out.println("Closeness warning: " + dist + " from Object at Latitude: " + a + " Longitude: " + b);
	}

	public void showGPS() {
		System.out.println("Lat: " + latitude + " \nLon: " + longitude + " \nDegree: " + degree + " \nDirection: "
				+ getDirection());
	}
}