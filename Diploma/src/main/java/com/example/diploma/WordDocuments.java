package com.example.diploma;

import com.example.diploma.Interfaces.InsertToWord;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.*;

import java.io.*;
import java.util.List;

/**
 * Класс с методами добавления данных из полей класса ControllerFilling в шаблоны документов
 */
public class WordDocuments implements InsertToWord {

    /**
     * Метод для вставки данных в шаблоны документов без таблиц внутри
     */
    public void insertToFormString(Client client)
            throws IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
        try {
            // Определение документа Word, который будет основой для добавления персональных данных
            XWPFDocument doc = new XWPFDocument(
                    OPCPackage.open("C:\\Users\\александр\\Desktop\\ДИПЛОМ Geekbrains\\ОСНОВНОЕ - ПРОЕКТ\\Diploma\\src\\main\\java\\com\\example\\diploma\\Forms\\Форма № 1.docx"));
            // Проход по параграфам внутри документа
            for (XWPFParagraph p : doc.getParagraphs()) {
                List<XWPFRun> runs = p.getRuns();
                if (runs != null) {
                    for (XWPFRun r : runs) {
                        String text = r.getText(0);
                        // Замена найденного опорного слова на данные из формы заполнения (client.getDate())
                        if (text != null && text.contains("date")) {
                            text = text.replace("date", client.getDate());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("name")) {
                            text = text.replace("name", client.getName());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("male")) {
                            text = text.replace("male", client.getGender());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("birth")) {
                            text = text.replace("birth", client.getBirth());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("city")) {
                            text = text.replace("city", client.getCity());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("street")) {
                            text = text.replace("street", client.getStreet());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("house")) {
                            text = text.replace("house", client.getHouse());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("flat")) {
                            text = text.replace("flat", client.getFlat());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("phone")) {
                            text = text.replace("phone", client.getPhone());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("passport")) {
                            text = text.replace("passport", client.getPassport());
                            r.setText(text, 0);
                        }
                    }
                }
            }

            // Создание нового документа на основе шаблона уже с заполеннными данными получателя услуг
            doc.write(new FileOutputStream("C:\\Users\\александр\\Desktop\\new1.docx"));
        } finally {
        }
    }

    /**
     * Метод для вставки данных в шаблоны документов c таблицами внутри
     */
    public void insertToFormTable(Client client)
            throws IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
        try {
            // Определение документа Word, который будет основой для добавления персональных данных
            XWPFDocument doc = new XWPFDocument(
                    OPCPackage.open("C:\\Users\\александр\\Desktop\\ДИПЛОМ Geekbrains\\ОСНОВНОЕ - ПРОЕКТ\\Diploma\\src\\main\\java\\com\\example\\diploma\\Forms\\Форма № 2.docx"));
            // Проход по таблицам внутри документа
            for (XWPFTable tbl : doc.getTables()) {
                for (XWPFTableRow row : tbl.getRows()) {
                    for (XWPFTableCell cell : row.getTableCells()) {
                        for (XWPFParagraph p : cell.getParagraphs()) {
                            for (XWPFRun r : p.getRuns()) {
                                String text = r.getText(0);
                                // Замена найденного опорного слова на данные из формы заполнения (client.getDate())
                                if (text != null && text.contains("date")) {
                                    text = text.replace("date", client.getDate());
                                    r.setText(text, 0);
                                }
                                if (text != null && text.contains("name")) {
                                    text = text.replace("name", client.getName());
                                    r.setText(text, 0);
                                }
                                if (text != null && text.contains("institution")) {
                                    text = text.replace("institution", client.getInstitution());
                                    r.setText(text, 0);
                                }
                            }
                        }
                    }
                }
            }

            // Создание нового документа на основе шаблона уже с заполеннными данными получателя услуг
            doc.write(new FileOutputStream("C:\\Users\\александр\\Desktop\\new2.docx"));
        } finally {
        }
    }
}
