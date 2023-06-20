package fr.yncrea.maxresadapter.models;

public record ApplianceModel (
    String deviceAddress,
    String name,
    boolean registered,
    String type,
    String brand,
    boolean defaultValue,
    String pdl
){
    @Override
    public String toString() {
        return "ApplianceModel{" +
                "deviceAddress='" + deviceAddress + '\'' +
                ", name='" + name + '\'' +
                ", registered=" + registered +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", defaultValue=" + defaultValue +
                ", pdl='" + pdl + '\'' +
                '}';
    }
}
