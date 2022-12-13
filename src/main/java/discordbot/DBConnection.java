package discordbot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private String host = "jdbc:postgresql://localhost/NorthWind2019";
    private String userName = "discordBot";
    private String password = "";

    public DBConnection() {
    }

    public void DBConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection dbConnection = DriverManager.getConnection(host, userName, password);
            System.out.println(dbConnection.getMetaData());
            System.out.println("DB Connected?");
            System.out.println(dbConnection.getClientInfo());
            if (dbConnection != null) {
                System.out.println("Successfully connected to MySQL database test");
            } else {
                System.out.println("Could not connect to the database");
            }
        } catch (SQLException error) {
            System.out.println(error + " SQL error");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
