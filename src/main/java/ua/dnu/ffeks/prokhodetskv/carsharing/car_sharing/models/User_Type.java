package ua.dnu.ffeks.prokhodetskv.carsharing.car_sharing.models;

public class User_Type {
    private int idType;
    private String typeName;

    public User_Type() {}

    public User_Type(int idType, String typeName) {
        this.idType = idType;
        this.typeName = typeName;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
