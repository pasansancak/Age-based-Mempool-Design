package method;

import java.util.ArrayList;
import java.util.List;

public class Mempool {
    private List<Transaction> transactions;
    private int thresholdSize;

    public Mempool(int thresholdSize) {
        this.transactions = new ArrayList<>();
        this.thresholdSize = thresholdSize;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public int getMempoolSize() {
        return transactions.size();
    }

    public void updateMempool(Transaction transaction) {
        if (getMempoolSize() >= thresholdSize) {
            System.out.println("Mempool size exceeds threshold. Taking necessary actions...");
        } else {
            addTransaction(transaction);
            System.out.println("Transaction succesfully added to Mempool. \n Transaction info:" + transaction.toString());
        }
    }

    public void processIncomingTransactions(List<Transaction> incomingTransactions, double minimumRelayFee,
                                            double minimumMiningFee, int minimumAgeLimit) {
        for (Transaction transaction : incomingTransactions) {
            double averageAge = 0;
            int numParentTransactions = transaction.getParentTransactions().length;

            // Check relay fee
            if (transaction.getRelayFee() > minimumRelayFee) {
                // Check mining fee
                if (transaction.getMiningFee() > minimumMiningFee) {
                    // Calculate average age
                    for (Transaction parentTransaction : transaction.getParentTransactions()) {
                        int parentAge = getParentTransactionAge(parentTransaction);
                        averageAge += parentAge;
                    }
                    averageAge /= numParentTransactions;

                    if (averageAge > minimumAgeLimit) {
                        updateMempool(transaction);
                    } else {
                        System.out.println("Transaction rejected. Low age factor.");
                    }
                }
            }
        }
    }

    private int getParentTransactionAge(Transaction parentTransaction) {
        return parentTransaction.getAge();
    }
}
