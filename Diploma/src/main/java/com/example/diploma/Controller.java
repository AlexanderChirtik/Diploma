package com.example.diploma;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Класс для регулирования приветственной страницы. В нем есть две кнопки для перехода либо к
 * заполнению документов,либо к просмотру уже созданных пакетов документов из базы данных
 */
public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button sendDocuments;

    @FXML
    private Button sentList;

    /**
     * Переход на две другие страницы
     */
    @FXML
    private void initialize() {

        sendDocuments.setOnAction(event -> {   // Действия при нажатии на кнопку с ip SendDocuments

            sendDocuments.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ViewFilling.fxml")); // Переход на страницу заполнения документов

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        sentList.setOnAction(event -> {   // Действия при нажатии на кнопку с ip SentList
            sentList.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ViewList.fxml")); // Переход на страницу со списком уже заполненных документов

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }
}
