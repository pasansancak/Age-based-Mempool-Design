package method;

import java.util.Arrays;

public class Transaction {
    private double relayFee;
    private double miningFee;
    private int age;
    private Transaction[] parentTransactions;

    public Transaction(double relayFee, double miningFee, Transaction[] parentTransactions, int age) {
        this.relayFee = relayFee;
        this.miningFee = miningFee;
        this.age = age;
        this.parentTransactions = parentTransactions;

    }

    public double getRelayFee() {
        return relayFee;
    }

    public double getMiningFee() {
        return miningFee;
    }

    public Transaction[] getParentTransactions() {
        return parentTransactions;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "relayFee=" + relayFee +
                ", miningFee=" + miningFee +
                ", age=" + age +
                '}';
    }
}
