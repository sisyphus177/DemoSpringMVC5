package demo.spring.model.pojo;

/**
 * Created by raist on 2016/5/24.
 *
 */
public class Transaction {
    private int fromAccount;
    private int toAccount;
    private double transferMoney;

    public int getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(int fromAccount) {
        this.fromAccount = fromAccount;
    }

    public int getToAccount() {
        return toAccount;
    }

    public void setToAccount(int toAccount) {
        this.toAccount = toAccount;
    }

    public double getTransferMoney() {
        return transferMoney;
    }

    public void setTransferMoney(double transferMoney) {
        this.transferMoney = transferMoney;
    }
}
