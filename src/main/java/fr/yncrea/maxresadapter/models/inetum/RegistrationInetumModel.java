package fr.yncrea.maxresadapter.models.inetum;

public record RegistrationInetumModel(
        String building,
        String buildingSpace,
        String device,
        String classification,
        String description,
        String serviceProviderEMSOwner
) {
    @Override
    public String toString() {
        return "RegistrationInetumModel{" +
                "building='" + building + '\'' +
                ", buildingSpace='" + buildingSpace + '\'' +
                ", device='" + device + '\'' +
                ", classification='" + classification + '\'' +
                ", description='" + description + '\'' +
                ", serviceProviderEMSOwner='" + serviceProviderEMSOwner + '\'' +
                '}';
    }
}
