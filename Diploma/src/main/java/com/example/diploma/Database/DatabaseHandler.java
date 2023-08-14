package com.example.diploma.Database;

import com.example.diploma.Interfaces.ConnectionDB;
import com.example.diploma.Interfaces.InsertDB;
import com.example.diploma.Interfaces.SelectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс с метода взаимодействия с базой данных в MySQL
 */
public class DatabaseHandler extends DatabaseConfigs implements ConnectionDB, InsertDB, SelectDB {

    /**
     * Метод для подключения к БД
     */
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {

        Connection dbConnection; // Экземпляр класса Connection для подключения к БД

        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName; // jdbc - стандарт взаимодействия Java-приложений с различными СУБД
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    /**
     * Метод внесения данных в БД
     */
    public void logging(String date, String name, String gender, String birth, String city, String street,
                        String house, String flat, String phone, String passport, String institution) {

        String insert = "INSERT INTO " + DatabaseConst.TABLE_NAME + "(" + DatabaseConst.CLIENT_DATE + ","
                + DatabaseConst.CLIENT_NAME + "," + DatabaseConst.CLIENT_GENDER + ","
                + DatabaseConst.CLIENT_BIRTH + "," + DatabaseConst.CLIENT_CITY + "," + DatabaseConst.CLIENT_STREET +
                "," + DatabaseConst.CLIENT_HOUSE + "," + DatabaseConst.CLIENT_FLAT + "," + DatabaseConst.CLIENT_PHONE
                + "," + DatabaseConst.CLIENT_PASSPORT + "," + DatabaseConst.CLIENT_INSTITUTION + ")" +
                " VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = getDbConnection().prepareStatement(insert);
            ps.setString(1, date);
            ps.setString(2, name);
            ps.setString(3, gender);
            ps.setString(4, birth);
            ps.setString(5, city);
            ps.setString(6, street);
            ps.setString(7, house);
            ps.setString(8, flat);
            ps.setString(9, phone);
            ps.setString(10, passport);
            ps.setString(11, institution);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод извлечения информации из БД
     */
    public List<String[]> getClient() {

        ResultSet resSet; // ResultSet - класс, позволяющий получить и содержать результат запроса к БД

        List<String[]> allData = new ArrayList<>(); // Набор строк, каждая из которых содержит информацию о получателе услуг (несколько столбцов из таблицы в БД)

        String select = "SELECT * FROM " + DatabaseConst.TABLE_NAME;
        try {
            PreparedStatement ps = getDbConnection().prepareStatement(select);
            resSet = ps.executeQuery();

            while (resSet.next()) {

                String[] values = new String[12];

                values[0] = Integer.toString(resSet.getInt(1));
                values[1] = resSet.getString(2);
                values[2] = resSet.getString(3);
                values[3] = resSet.getString(4);
                values[4] = resSet.getString(5);
                values[5] = resSet.getString(6);
                values[6] = resSet.getString(7);
                values[7] = resSet.getString(8);
                values[8] = resSet.getString(9);
                values[9] = resSet.getString(10);
                values[10] = resSet.getString(11);
                values[11] = resSet.getString(12);

                allData.add(values);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return allData;
    }
}
