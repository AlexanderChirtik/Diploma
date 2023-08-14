package com.example.diploma.Database;

/**
 * Класс предназначен для соединения с базой данных
 */
public class DatabaseConfigs {
    protected String dbHost = "localhost"; // IP-адрес 127.0.0.1 для подключения к БЛ
    protected String dbPort = "3306"; // Порт подключения по умолчанию
    protected String dbUser = "root"; // Учетная запись суперпользователя
    protected String dbPass = "12345"; // Пароль для входа в учетную запись
    protected String dbName = "diploma"; // Название БД
}
