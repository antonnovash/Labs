package Lab_5;

import java.io.Serializable;
import java.util.ResourceBundle;

public class Invoice extends ObjectWithResourceBundle implements Serializable {
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
        return resourceBundle.getString("invoice") + "{ " +
                resourceBundle.getString("cost")+ '=' + cost +
                " $ }";
    }
}
