package ua.dnu.ffeks.prokhodetskv.carsharing.car_sharing.models;

public class Services {
    private int idService;
    private String serviceName; // Це поле має геттер getServiceName()
    private String description;
    private double price;

    public Services() {}

    public Services(int idService, String serviceName, String description, double price) {
        this.idService = idService;
        this.serviceName = serviceName;
        this.description = description;
        this.price = price;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Корисно для відображення у ComboBox, якщо знадобиться
    @Override
    public String toString() {
        return serviceName;
    }
}