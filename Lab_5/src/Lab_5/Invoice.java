package Lab_5;

import java.io.Serializable;

public class Invoice implements Serializable {
    private double cost;

    public Invoice(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "cost=" + cost +
                "$}";
    }
}
