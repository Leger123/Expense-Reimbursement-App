package dao;

/**
 * @author Kevin Dian
 */

public class ConnectionUtil {
    public static String url = "jdbc:postgresql://" + System.getenv("DATABASE_URI") + "/ERS";
    public static String username = System.getenv("DATABASE_USERNAME");
    public static String password = System.getenv("DATABASE_PASSWORD");
}
