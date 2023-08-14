package com.example.diploma;

/**
 * Класс с данными получателя услуг, которые будут записаны в документы
 */
public class Client {
    private String id;
    private String date;
    private String name;
    private String gender;
    private String birth;
    private String city;
    private String street;
    private String house;
    private String flat;
    private String phone;
    private String passport;
    private String institution;

    /**
     * Конструктор для метода initData класса ControllerList
     */
    public Client(String id, String date, String name, String gender, String birth, String city, String street,
                  String house, String flat, String phone, String passport, String institution) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
        this.phone = phone;
        this.passport = passport;
        this.institution = institution;
    }

    /**
     * Конструктор для методов insertToFormString и insertToFormTable класса WordDocuments
     */
    public Client(String date, String name, String gender, String birth, String city, String street,
                  String house, String flat, String phone, String passport, String institution) {

        this.date = date;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
        this.phone = phone;
        this.passport = passport;
        this.institution = institution;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
