package method;

public class Transaction {
    private double relayFee;
    private double miningFee;

    public Transaction(double relayFee, double miningFee) {
        this.relayFee = relayFee;
        this.miningFee = miningFee;
    }

    public double getRelayFee() {
        return relayFee;
    }

    public double getMiningFee() {
        return miningFee;
    }
}
