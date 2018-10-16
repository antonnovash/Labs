package Lab_5;

import java.io.Serializable;

public class Customer implements Serializable {
    private double money;

    public Customer(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
