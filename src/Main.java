import method.Mempool;
import method.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a mempool with a threshold size
        Mempool mempool = new Mempool(3);

        // Create example transactions
        Transaction tx1 = new Transaction(0.001, 0.002, new Transaction[]{}, 7);
        Transaction tx2 = new Transaction(0.0015, 0.0025, new Transaction[]{tx1}, 4);
        Transaction tx3 = new Transaction(0.0012, 0.0023, new Transaction[]{tx1,tx2}, 2);
        Transaction tx4 = new Transaction(0.0013, 0.0022, new Transaction[]{tx1, tx2, tx3}, 0);
        Transaction tx5 = new Transaction(0.0018, 0.0027, new Transaction[]{tx4}, 0);
        Transaction tx6 = new Transaction(0.0041, 0.002, new Transaction[]{tx4}, 0);
        Transaction tx7 = new Transaction(0.00135, 0.0425, new Transaction[]{tx1,tx2,tx3}, 11);
        Transaction tx8 = new Transaction(0.00412, 0.0073, new Transaction[]{tx1}, 4);
        Transaction tx9 = new Transaction(0.0213, 0.0222, new Transaction[]{tx7}, 4);
        Transaction tx10 = new Transaction(0.0118, 0.0127, new Transaction[]{tx3}, 1);

        List<Transaction> incomingTransactions = new ArrayList<>();
        incomingTransactions.add(tx1);
        incomingTransactions.add(tx2);
        incomingTransactions.add(tx3);
        incomingTransactions.add(tx4);
        incomingTransactions.add(tx5);
        incomingTransactions.add(tx6);
        incomingTransactions.add(tx7);
        incomingTransactions.add(tx8);
        incomingTransactions.add(tx9);
        incomingTransactions.add(tx10);

        // Process the incoming transactions
        mempool.processIncomingTransactions(incomingTransactions, 0.001, 0.002, 5);

        // Check the mempool size
        System.out.println("Mempool size: " + mempool.getMempoolSize());
    }
}
