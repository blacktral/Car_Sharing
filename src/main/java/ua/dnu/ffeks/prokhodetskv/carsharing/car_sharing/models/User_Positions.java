package ua.dnu.ffeks.prokhodetskv.carsharing.car_sharing.models;

import java.time.LocalDate;

public class User_Positions {
    private int idUser;
    private int idPosition;
    private LocalDate startDate;
    private LocalDate endDate;
    private String leavingReason;
    private double salary;

    public User_Positions() {}

    public User_Positions(int idUser, int idPosition, LocalDate startDate, LocalDate endDate, double salary, String leavingReason) {
        this.idUser = idUser;
        this.idPosition = idPosition;
        this.startDate = startDate;
        this.endDate = endDate;
        this.salary = salary;
        this.leavingReason = leavingReason;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getLeavingReason() {
        return leavingReason;
    }

    public void setLeavingReason(String leavingReason) {
        this.leavingReason = leavingReason;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
