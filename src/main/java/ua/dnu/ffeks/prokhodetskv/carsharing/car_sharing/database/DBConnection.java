package ua.dnu.ffeks.prokhodetskv.carsharing.car_sharing;

import java.sql.*;

public class DBConnection {

    // Налаштування бази даних
    private final String dbHost = "localhost";
    private final String dbPort = "5432";
    private final String dbUser = "postgres"; // Ваш логін (зазвичай postgres)
    private final String dbPass = "1234";     // Ваш пароль до БД
    private final String dbName = "Car_Sharing"; // Назва вашої бази даних

    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        // Формуємо рядок підключення
        // jdbc:postgresql://localhost:5432/car_sharing_db
        String connectionString = "jdbc:postgresql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("org.postgresql.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }
}
