package ua.dnu.ffeks.prokhodetskv.carsharing.car_sharing.models;

import java.time.LocalDateTime;

public class Rent {


    private int idRent;
    private LocalDateTime giving;
    private LocalDateTime rentalPeriod; // Планована дата повернення
    private LocalDateTime returnDate;   // Фактична дата повернення (може бути null)
    private int idCar;
    private int idClient;
    private int idEmployee;
    private String rentStatus;

    public Rent() {
    }

    public Rent(int idRent, LocalDateTime giving, LocalDateTime rentalPeriod, LocalDateTime returnDate,
                int idCar, int idClient, int idEmployee, String rentStatus) {
        this.idRent = idRent;
        this.giving = giving;
        this.rentalPeriod = rentalPeriod;
        this.returnDate = returnDate;
        this.idCar = idCar;
        this.idClient = idClient;
        this.idEmployee = idEmployee;
        this.rentStatus = rentStatus;
    }
    public int getIdRent() {
        return idRent;
    }

    public void setIdRent(int idRent) {
        this.idRent = idRent;
    }

    public LocalDateTime getGiving() {
        return giving;
    }

    public void setGiving(LocalDateTime giving) {
        this.giving = giving;
    }

    public LocalDateTime getRentalPeriod() {
        return rentalPeriod;
    }

    public void setRentalPeriod(LocalDateTime rentalPeriod) {
        this.rentalPeriod = rentalPeriod;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(String rentStatus) {
        this.rentStatus = rentStatus;
    }

}

