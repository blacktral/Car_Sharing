package ua.dnu.ffeks.prokhodetskv.carsharing.car_sharing.models;

public class Car_Brands {
    private int idBrand;
    private String nameBrand;
    private String techRequirements;
    private String description;

    public Car_Brands() {}

    public Car_Brands(int idBrand, String nameBrand, String techRequirements, String description) {
        this.idBrand = idBrand;
        this.nameBrand = nameBrand;
        this.techRequirements = techRequirements;
        this.description = description;
    }

    public int getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(int idBrand) {
        this.idBrand = idBrand;
    }

    public String getNameBrand() {
        return nameBrand;
    }

    public void setNameBrand(String nameBrand) {
        this.nameBrand = nameBrand;
    }

    public String getTechRequirements() {
        return techRequirements;
    }

    public void setTechRequirements(String techRequirements) {
        this.techRequirements = techRequirements;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
