package Lab_5;

import java.io.Serializable;

public class Constructor implements Serializable {

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
        return "The technical task is registered.";
    }
    public Invoice coastProject(Task task) {

        return new Invoice(task.getDescription().length() * 10520.5);
    }
    public Squad[] createSquad(Task task) {

        return new Squad[task.getDescription().length()];
    }
}
