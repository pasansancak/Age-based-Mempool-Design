import method.Mempool;
import method.Transaction;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        double minimumRelayFee = 0.001;
        double minimumMiningFee = 0.01;
        int thresholdSize = 1000;

        Mempool mempool = new Mempool(thresholdSize, minimumRelayFee, minimumMiningFee);

        // Add incoming transactions
        List<Transaction> incomingTransactions = new ArrayList<>();
        incomingTransactions.add(new Transaction(0.002, 0.015));
        incomingTransactions.add(new Transaction(0.001, 0.005));
        incomingTransactions.add(new Transaction(0.003, 0.02));

        for (Transaction transaction : incomingTransactions) {
            mempool.addTransaction(transaction);
        }

        int mempoolSize = mempool.getMempoolSize();
        System.out.println("method.Mempool Size: " + mempoolSize);
    }
}
