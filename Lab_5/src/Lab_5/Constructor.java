package Lab_5;

import java.io.Serializable;
import java.util.ResourceBundle;

public class Constructor extends ObjectWithResourceBundle  implements Serializable {
    public static final double COST = 10520.5;
    public Constructor() {
    }

    public String  registerTask(Invoice invoice,Customer customer) {
        try {
            if(invoice.getCost() - customer.getMoney() > 0)
                throw new Exception("You do not have enough funds to create a multi-storey building. The technical task is not registered.");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        return resourceBundle.getString("task");
    }
    public Invoice costProject(Task task) {

        return new Invoice(task.getDescription().length() * COST);
    }
    public Squad[] createSquad(Task task) {

        return new Squad[task.getDescription().length()];
    }

    @Override
    public String toString() {
        return resourceBundle.getString("constructor") + " {" + resourceBundle.getString("task") + '}';
    }
}
