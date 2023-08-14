package com.example.diploma.Interfaces;

import com.example.diploma.Client;

import java.io.IOException;

public interface InsertToWord {
    void insertToFormString(Client client)
            throws IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException;

    void insertToFormTable(Client client)
            throws IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException;
}
