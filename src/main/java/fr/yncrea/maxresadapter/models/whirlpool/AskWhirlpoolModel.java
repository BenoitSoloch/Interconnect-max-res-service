package fr.yncrea.maxresadapter.models.whirlpool;

public record AskWhirlpoolModel(
        String appliances,
        String playerid,
        String token
) {
    @Override
    public String toString() {
        return "AskModel{" +
                "appliances='" + appliances + '\'' +
                ", playerid='" + playerid + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
