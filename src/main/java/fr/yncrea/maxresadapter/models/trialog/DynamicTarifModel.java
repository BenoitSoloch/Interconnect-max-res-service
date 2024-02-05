package fr.yncrea.maxresadapter.models.trialog;

public record DynamicTarifModel(
        String costValue,
        String beginDateTime,
        String endDateTime,
        String building,
        String dp,
        String beginning,
        String end,
        String fc,
        String q,
        String timestamp,
        String ts,
        String value
) {
    @Override
    public String toString() {
        return "DynamicTarifModel{" +
                "costValue='" + costValue + '\'' +
                ", beginDateTime='" + beginDateTime + '\'' +
                ", endDateTime='" + endDateTime + '\'' +
                ", building='" + building + '\'' +
                ", dp='" + dp + '\'' +
                ", beginning='" + beginning + '\'' +
                ", end='" + end + '\'' +
                ", fc='" + fc + '\'' +
                ", q='" + q + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", ts='" + ts + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
