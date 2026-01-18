package ua.dnu.ffeks.prokhodetskv.carsharing.car_sharing.models;

public class Car {

    private int idCar;
    private int idBrand;
    private String numberCar;
    private String numberBody;
    private String numberEngine;
    private int productionYear;
    private int mileage;
    private int serviceInterval;
    private double carPrice;
    private double carPriceInDay;
    private String status;
    private String specialMarks;

    // Додаткове поле для UI (назва бренду замість ID)
    private String brandName;

    public Car() {}

    public Car(int idCar, int idBrand, String numberCar, String numberBody, String numberEngine,
               int productionYear, int mileage, int serviceInterval, double carPrice,
               double carPriceInDay, String status, String specialMarks) {
        this.idCar = idCar;
        this.idBrand = idBrand;
        this.numberCar = numberCar;
        this.numberBody = numberBody;
        this.numberEngine = numberEngine;
        this.productionYear = productionYear;
        this.mileage = mileage;
        this.serviceInterval = serviceInterval;
        this.carPrice = carPrice;
        this.carPriceInDay = carPriceInDay;
        this.status = status;
        this.specialMarks = specialMarks;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public int getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(int idBrand) {
        this.idBrand = idBrand;
    }

    public String getNumberCar() {
        return numberCar;
    }

    public void setNumberCar(String numberCar) {
        this.numberCar = numberCar;
    }

    public String getNumberBody() {
        return numberBody;
    }

    public void setNumberBody(String numberBody) {
        this.numberBody = numberBody;
    }

    public String getNumberEngine() {
        return numberEngine;
    }

    public void setNumberEngine(String numberEngine) {
        this.numberEngine = numberEngine;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getServiceInterval() {
        return serviceInterval;
    }

    public void setServiceInterval(int serviceInterval) {
        this.serviceInterval = serviceInterval;
    }

    public double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(double carPrice) {
        this.carPrice = carPrice;
    }

    public double getCarPriceInDay() {
        return carPriceInDay;
    }

    public void setCarPriceInDay(double carPriceInDay) {
        this.carPriceInDay = carPriceInDay;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecialMarks() {
        return specialMarks;
    }

    public void setSpecialMarks(String specialMarks) {
        this.specialMarks = specialMarks;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

}
