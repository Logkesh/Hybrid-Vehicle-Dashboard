package hybrid;

public class User {
	private static String user_name;
	private static String user_id;

	private static void setUserID() {
		User.user_id = java.util.UUID.randomUUID().toString();

	}

	public static void setUserName(String user) {
		User.user_name = user;
		User.setUserID();
	}

	public String getUsername() {
		return user_name;
	}

	public String getUser_id() {
		return user_id;
	}
}