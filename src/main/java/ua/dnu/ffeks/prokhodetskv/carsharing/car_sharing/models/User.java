package ua.dnu.ffeks.prokhodetskv.carsharing.car_sharing.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
    private int idUser;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate dateBirthday;
    private LocalDateTime createdAt;
    private String sex;
    private String address;
    private String phoneNumber;
    private String passportData;
    private int idType;

    private String typeName;


    public User() {}


    public User(String firstName, String middleName, String lastName, LocalDate dateBirthday,
                String sex, String address, String phoneNumber, String passportData, int idType) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateBirthday = dateBirthday;
        this.sex = sex;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.passportData = passportData;
        this.idType = idType;
        this.createdAt = LocalDateTime.now();
    }

    public User(int idUser, String firstName, String middleName, String lastName,
                LocalDate dateBirthday, LocalDateTime createdAt, String sex,
                String address, String phoneNumber, String passportData, int idType) {
        this.idUser = idUser;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateBirthday = dateBirthday;
        this.createdAt = createdAt;
        this.sex = sex;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.passportData = passportData;
        this.idType = idType;
    }


    public int getIdUser() { return idUser; }
    public void setIdUser(int idUser) { this.idUser = idUser; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public LocalDate getDateBirthday() { return dateBirthday; }
    public void setDateBirthday(LocalDate dateBirthday) { this.dateBirthday = dateBirthday; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public String getSex() { return sex; }
    public void setSex(String sex) { this.sex = sex; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getPassportData() { return passportData; }
    public void setPassportData(String passportData) { this.passportData = passportData; }

    public int getIdType() { return idType; }
    public void setIdType(int idType) { this.idType = idType; }

    public String getTypeName() { return typeName; }
    public void setTypeName(String typeName) { this.typeName = typeName; }
}
