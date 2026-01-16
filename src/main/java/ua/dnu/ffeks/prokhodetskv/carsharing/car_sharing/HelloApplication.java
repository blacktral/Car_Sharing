package ua.dnu.ffeks.prokhodetskv.carsharing.car_sharing;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ua.dnu.ffeks.prokhodetskv.carsharing.car_sharing.database.DBConnection;

import java.io.IOException;
import java.sql.Connection;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // Завантажуємо саме admin-view.fxml, а не hello-view!
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("admin-view.fxml"));

        // Встановлюємо розмір вікна (ширина 900, висота 600)
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);

        stage.setTitle("Car Sharing - Admin Panel");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        // --- ПЕРЕВІРКА БД ПЕРЕД ЗАПУСКОМ ВІКНА ---
        System.out.println("Спроба підключення до PostgreSQL...");
        try {
            DBConnection db = new DBConnection();
            Connection conn = db.getDbConnection();
            if (conn != null) {
                System.out.println("✅ УСПІХ! База даних підключена.");
            } else {
                System.out.println("❌ ПОМИЛКА! З'єднання повернуло null.");
            }
        } catch (Exception e) {
            System.out.println("❌ КРИТИЧНА ПОМИЛКА БД: " + e.getMessage());
            e.printStackTrace();
        }
        // ------------------------------------------

        launch();
    }
}