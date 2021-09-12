package bankingexample;

import javax.persistence.*;

@Entity
public class CreditCard extends PinCode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int number;

    private int balance;

    private int limit;

    @ManyToOne(cascade = CascadeType.PERSIST)
    public Bank bank;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="pincode_id")
    public PinCode pinCode;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", number=" + number +
                ", balance=" + balance +
                ", limit=" + limit +
                ", bank=" + bank +
                ", pinCode=" + pinCode +
                '}';
    }
}
