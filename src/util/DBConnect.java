package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Sheab
 * Date: 10/19/13
 * Time: 5:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class DBConnect
{
    public static final String DB_DRIVER="com.mysql.jdbc.Driver";
    public static final String DB_HOST = "localhost";
    public static final String DB_NAME="thesis";
    public static final String DB_USER="root";
    public static final String DB_PASSWORD="";
    private static Connection connection;


    public static Connection connect()
    {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        try {
            connection = DriverManager.getConnection("jdbc:mysql://"+DB_HOST+":3306/",DB_USER,DB_PASSWORD);

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return null;
        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
            return connection;
        } else {
            System.out.println("Failed to make connection!");
            return null;
        }

    }



    public static void close() throws SQLException {
            connection.close();
    }


}
