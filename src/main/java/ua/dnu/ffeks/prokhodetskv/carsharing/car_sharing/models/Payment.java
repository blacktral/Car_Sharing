package ua.dnu.ffeks.prokhodetskv.carsharing.car_sharing.models;

import java.time.LocalDateTime;

public class Payment {
    private int idPayment;
    private int idRent;
    private double amount;
    private String type;
    private String method;
    private LocalDateTime createdAt;

    public Payment() {}

    public Payment(int idPayment, int idRent, double amount, String type, String method, LocalDateTime createdAt) {
        this.idPayment = idPayment;
        this.idRent = idRent;
        this.amount = amount;
        this.type = type;
        this.method = method;
        this.createdAt = createdAt;
    }

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public int getIdRent() {
        return idRent;
    }

    public void setIdRent(int idRent) {
        this.idRent = idRent;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
