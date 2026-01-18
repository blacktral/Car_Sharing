package ua.dnu.ffeks.prokhodetskv.carsharing.car_sharing.models;

import java.time.LocalDate;

    public class Maintenance {
        private int idMaintenance;
        private int idCar;
        private int idMechanic;
        private LocalDate dateService;
        private String description;
        private LocalDate dateFinish;
        private double price;
        private int mileageAtMoment;
        private String type;

        // НОВЕ ПОЛЕ
        private String carNumber;

        public Maintenance() {}

        public Maintenance(int idMaintenance, int idCar, int idMechanic, LocalDate dateService,
                           String description, LocalDate dateFinish, double price,
                           int mileageAtMoment, String type, String carNumber) {
            this.idMaintenance = idMaintenance;
            this.idCar = idCar;
            this.idMechanic = idMechanic;
            this.dateService = dateService;
            this.description = description;
            this.dateFinish = dateFinish;
            this.price = price;
            this.mileageAtMoment = mileageAtMoment;
            this.type = type;
            this.carNumber = carNumber;
        }
    public int getIdMaintenance() {
        return idMaintenance;
    }

    public void setIdMaintenance(int idMaintenance) {
        this.idMaintenance = idMaintenance;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public int getIdMechanic() {
        return idMechanic;
    }

    public void setIdMechanic(int idMechanic) {
        this.idMechanic = idMechanic;
    }

    public LocalDate getDateService() {
        return dateService;
    }

    public void setDateService(LocalDate dateService) {
        this.dateService = dateService;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(LocalDate dateFinish) {
        this.dateFinish = dateFinish;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMileageAtMoment() {
        return mileageAtMoment;
    }

    public void setMileageAtMoment(int mileageAtMoment) {
        this.mileageAtMoment = mileageAtMoment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCarNumber() {
            return carNumber;
    }
    public void setCarNumber(String carNumber) {
            this.carNumber = carNumber;
    }
}
