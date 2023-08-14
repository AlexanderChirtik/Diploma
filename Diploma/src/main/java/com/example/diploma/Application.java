package com.example.diploma;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {

    /**
     * Метод для запуска приложения. Создание контейнера для отображения всех графических элементов
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("View.fxml")); // Загрузка интерфейса приложения, содержащегося в файле View.fxml
        Scene scene = new Scene(fxmlLoader.load(), 1200, 700); // Размер окна приложения
        stage.getIcons().add(new Image("file:/C:/Users/александр/Desktop/ДИПЛОМ Geekbrains/ОСНОВНОЕ - ПРОЕКТ/Diploma/src/main/resources/com/example/diploma/Pictures/Icon.png")); // Иконка приложения
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}