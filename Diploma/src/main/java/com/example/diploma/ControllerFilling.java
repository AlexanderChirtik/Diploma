package com.example.diploma;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.diploma.Database.DatabaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/**
 * Класс заполнения данных, которые будут автоматически вставлены в шаблоны документов
 */
public class ControllerFilling {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField birth;

    @FXML
    private TextField city;

    @FXML
    private Button dataSend;

    @FXML
    private TextField date;

    @FXML
    private TextField flat;

    @FXML
    private TextField house;

    @FXML
    private ComboBox<String> institution;

    //Создание вариантов выбора для элемента ComboBox <String> institution
    private ObservableList<String> CBOptions = FXCollections.observableArrayList("Учреждение 1", "Учреждение 2", "Учреждение 3", "Учреждение 4");
    private ComboBox<String> selectedItem = new ComboBox<String>(CBOptions);

    @FXML
    private CheckBox male;

    @FXML
    private TextField name;

    @FXML
    private TextField passport;

    @FXML
    private TextField phone;

    @FXML
    private TextField street;

    @FXML
    private void initialize() {

        institution.setValue("Учреждение 1"); //Установка варианта "Учреждение 1" по умолчанию для элемента ComboBox <String> institution
        institution.setItems(CBOptions);

        /**
         * Действия при нажатии на кнопку с ip dataSend
         */
        dataSend.setOnAction(event -> {

            String date = this.date.getText();
            String name = this.name.getText();
            String gender = "";
            String birth = this.birth.getText();
            String city = this.city.getText();
            String street = this.street.getText();
            String house = this.house.getText();
            String flat = this.flat.getText();
            String phone = this.phone.getText();
            String passport = this.passport.getText();
            String institution = this.institution.getSelectionModel().getSelectedItem();

            if (male.isSelected())
                gender = "Мужской";
            else
                gender = "Женский";

            Client client = new Client(date, name, gender, birth, city, street, house, flat, phone, passport, institution);

            WordDocuments wd = new WordDocuments(); //Внесение данных в шаблоны Word документов
            try {
                wd.insertToFormString(client);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InvalidFormatException e) {
                throw new RuntimeException(e);
            }

            try {
                wd.insertToFormTable(client);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InvalidFormatException e) {
                throw new RuntimeException(e);
            }

            DatabaseHandler db = new DatabaseHandler(); // Создание экземпляра класса DatabaseHandler для вызова метода logging
            db.logging(date, name, gender, birth, city, street, house, flat, phone, passport, institution); // Занесение данных в базу данных в MySQL

            dataSend.getScene().getWindow().hide(); // Закрытие окна

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ViewAfterFilling.fxml")); // Переход на страницу с уведомлением о завершении заполнения документов

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

