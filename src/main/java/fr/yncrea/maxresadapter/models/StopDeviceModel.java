package fr.yncrea.maxresadapter.models;

public record StopDeviceModel(
        String ls,
        String pdl,
        String dinf,
        String deviceId,
        String deviceName,
        String state,
        String emergency
) {
    @Override
    public String toString() {
        return "{" +
                "\"ls\":\"" + ls + '\"' +
                ", \"pdl\":\"" + pdl + '\"' +
                ", \"dinf\":\"" + dinf + '\"' +
                ", \"deviceId\":\"" + deviceId + '\"' +
                ", \"deviceName\":\"" + deviceName + '\"' +
                ", \"state\":\"" + state + '\"' +
                ", \"emergency\":\"" + emergency + '\"' +
                '}';
    }
}