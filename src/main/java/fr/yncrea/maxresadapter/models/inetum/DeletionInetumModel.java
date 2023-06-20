package fr.yncrea.maxresadapter.models.inetum;

public record DeletionInetumModel(
        String building,
        String buildingSpace,
        String device
) {
    @Override
    public String toString() {
        return "DeletionInetumModel{" +
                "building='" + building + '\'' +
                ", buildingSpace='" + buildingSpace + '\'' +
                ", device='" + device + '\'' +
                '}';
    }
}
