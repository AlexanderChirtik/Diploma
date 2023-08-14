package com.example.diploma;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.example.diploma.Database.DatabaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Класс вывода всех получателей услуг из базы данных на экран приложения
 */
public class ControllerList {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Client, String> fieldBirth;

    @FXML
    private TableColumn<Client, String> fieldCity;

    @FXML
    private TableColumn<Client, String> fieldDate;

    @FXML
    private TableColumn<Client, String> fieldFlat;

    @FXML
    private TableColumn<Client, String> fieldGender;

    @FXML
    private TableColumn<Client, String> fieldHoume;

    @FXML
    private TableColumn<Client, Integer> fieldID;

    @FXML
    private TableColumn<Client, String> fieldInstitution;

    @FXML
    private TableColumn<Client, String> fieldName;

    @FXML
    private TableColumn<Client, String> fieldPassport;

    @FXML
    private TableColumn<Client, String> fieldPhone;

    @FXML
    private TableColumn<Client, String> fieldStreet;

    @FXML
    private TableView<Client> tableView;

    private ObservableList<Client> list = FXCollections.observableArrayList(); //Создание списка, в который по очереди будут добавлены все строки из базы данных

    /**
     * Метод добавления строк из базы данных в список list
     */
    private void initData() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        List<String[]> tableValues = dbHandler.getClient();
        for (int i = 0; i < tableValues.size(); i++) {
            list.add(new Client(tableValues.get(i)[0], tableValues.get(i)[1], tableValues.get(i)[2], tableValues.get(i)[3],
                    tableValues.get(i)[4], tableValues.get(i)[5], tableValues.get(i)[6], tableValues.get(i)[7],
                    tableValues.get(i)[8], tableValues.get(i)[9], tableValues.get(i)[10], tableValues.get(i)[11]));
        }
    }

    @FXML
    private void initialize() {

        initData(); // При попадании на страницу метод initData() запускается автоматически

        fieldID.setCellValueFactory(new PropertyValueFactory<Client, Integer>("id"));
        fieldDate.setCellValueFactory(new PropertyValueFactory<Client, String>("date"));
        fieldName.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
        fieldGender.setCellValueFactory(new PropertyValueFactory<Client, String>("gender"));
        fieldBirth.setCellValueFactory(new PropertyValueFactory<Client, String>("birth"));
        fieldCity.setCellValueFactory(new PropertyValueFactory<Client, String>("city"));
        fieldStreet.setCellValueFactory(new PropertyValueFactory<Client, String>("street"));
        fieldHoume.setCellValueFactory(new PropertyValueFactory<Client, String>("house"));
        fieldFlat.setCellValueFactory(new PropertyValueFactory<Client, String>("flat"));
        fieldPhone.setCellValueFactory(new PropertyValueFactory<Client, String>("phone"));
        fieldPassport.setCellValueFactory(new PropertyValueFactory<Client, String>("passport"));
        fieldInstitution.setCellValueFactory(new PropertyValueFactory<Client, String>("institution"));

        tableView.setItems(list); // Внесение элементов из списка list в ячейки таблицы tableView
    }
}