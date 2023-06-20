package fr.yncrea.maxresadapter.models.whirlpool;

public record RegistrationWhirlpoolModel(
        String deviceAddress,
        String register,
        String playerid,
        String token,
        boolean registered
) {
    @Override
    public String toString() {
        return "RegistrationWhirlpoolModel{" +
                "deviceAddress='" + deviceAddress + '\'' +
                ", register='" + register + '\'' +
                ", playerid='" + playerid + '\'' +
                ", token='" + token + '\'' +
                ", registered=" + registered +
                '}';
    }
}
