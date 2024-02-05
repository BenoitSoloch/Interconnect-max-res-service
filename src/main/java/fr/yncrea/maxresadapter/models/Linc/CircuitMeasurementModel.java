package fr.yncrea.maxresadapter.models.Linc;

public record CircuitMeasurementModel(
        float energy_active_exported,
        float energy_active_imported,
        String timestamp
) {
    @Override
    public String toString() {
        return "CircuitMeasurementModel{" +
                "energy_active_exported=" + energy_active_exported +
                ", energy_active_imported=" + energy_active_imported +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
