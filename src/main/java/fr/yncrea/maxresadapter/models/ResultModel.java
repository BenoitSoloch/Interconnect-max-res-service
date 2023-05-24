package fr.yncrea.maxresadapter.models;

public record ResultModel(
        String type,
        String response,
        String details,
        String status,
        String timestamp
) {

    @Override
    public String toString() {
        return "ResultModel{" +
                "type='" + type + '\'' +
                ", response='" + response + '\'' +
                ", details=" + details +
                ", status='" + status + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
