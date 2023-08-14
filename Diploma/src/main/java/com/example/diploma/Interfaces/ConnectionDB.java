package com.example.diploma.Interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionDB {
    public Connection getDbConnection() throws ClassNotFoundException, SQLException;
}
