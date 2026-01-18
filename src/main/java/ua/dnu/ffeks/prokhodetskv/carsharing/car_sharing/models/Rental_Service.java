package ua.dnu.ffeks.prokhodetskv.carsharing.car_sharing.models;

public class Rental_Service {
    private int idRentalServices;
    private int rentId;
    private int idService;
    private int quantity;
    private double priceAtMoment; // Ціна на момент замовлення

    // Додаткові поля для красивого відображення в таблиці
    private String serviceName;

    public Rental_Service() {}

    public Rental_Service(int idRentalServices, int rentId, int idService, int quantity, double priceAtMoment) {
        this.idRentalServices = idRentalServices;
        this.rentId = rentId;
        this.idService = idService;
        this.quantity = quantity;
        this.priceAtMoment = priceAtMoment;
    }


    public int getIdRentalServices() {
        return idRentalServices;
    }

    public void setIdRentalServices(int idRentalServices) {
        this.idRentalServices = idRentalServices;
    }

    public int getRentId() {
        return rentId;
    }

    public void setRentId(int rentId) {
        this.rentId = rentId;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPriceAtMoment() {
        return priceAtMoment;
    }

    public void setPriceAtMoment(double priceAtMoment) {
        this.priceAtMoment = priceAtMoment;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    public String getserviceName() { return serviceName; }
    public void setserviceName(String serviceName) { this.serviceName = serviceName; }
}
