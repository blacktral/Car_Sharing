package ua.dnu.ffeks.prokhodetskv.carsharing.car_sharing.models;

public class Positions {
    private int idPosition;
    private String positionName;
    private double salary;
    private String responsibilities;
    private String requirements;

    public Positions() {}

    public Positions(int idPosition, String positionName, double salary, String responsibilities, String requirements) {
        this.idPosition = idPosition;
        this.positionName = positionName;
        this.salary = salary;
        this.responsibilities = responsibilities;
        this.requirements = requirements;
    }

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

}
