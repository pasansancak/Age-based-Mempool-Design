package method;

import java.util.ArrayList;
import java.util.List;

public class Mempool {
    private List<Transaction> transactions;
    private int thresholdSize;
    private double minimumRelayFee;
    private double minimumMiningFee;

    public Mempool(int thresholdSize, double minimumRelayFee, double minimumMiningFee) {
        this.transactions = new ArrayList<>();
        this.thresholdSize = thresholdSize;
        this.minimumRelayFee = minimumRelayFee;
        this.minimumMiningFee = minimumMiningFee;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        updateMempool();
    }

    private void updateMempool() {
        while (transactions.size() > thresholdSize) {
            double relayFee = transactions.get(0).getRelayFee();
            double miningFee = transactions.get(0).getMiningFee();
            if (relayFee > minimumRelayFee) {
                if (miningFee > minimumMiningFee) {
                    transactions.remove(0);
                } else {
                    transactions.remove(0);
                    // method.Transaction rejected as it only pays relay fee
                }
            } else {
                transactions.remove(0);
            }
        }
    }

    public int getMempoolSize() {
        return transactions.size();
    }
}
