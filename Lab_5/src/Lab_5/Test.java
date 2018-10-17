package Lab_5;

import java.util.Random;
import java.util.Locale;
import java.util.ResourceBundle;

public class Test {

    public static void main(String args[]) throws Exception {

        Task task = new Task("Build a five-story house.");
        Constructor constructor = new Constructor();
        Customer customer = new Customer(1000000);
        Invoice invoice = constructor.costProject(task);
        Locale.setDefault(new Locale(args[0],args[1]));
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Base");

        // Create Squard
        String[] employeeNames = {"Anton","Alex","Max","Slava","Vadim","Egor","Kate","Masha","Nikita"};
        Squad[] employee = constructor.createSquad(task);
        Random random = new Random();
        for(int i = 0; i < employee.length; i++) {
            employee[i] = new Squad(employeeNames[random.nextInt(9)],Locale.getDefault());
        }

        Connector.writeObject(task,"src\\Lab_5\\task.dat");
        Connector.writeObject(constructor,"src\\Lab_5\\registeredTask.dat");
        Connector.writeObject(invoice,"src\\Lab_5\\invoice.dat");
        Connector.writeObject(employee,"src\\Lab_5\\squad.dat");

        System.out.println(resourceBundle.getString("mode"));
        System.out.println(Connector.readObject("src\\Lab_5\\task.dat".toString(), Task.class));
        System.out.println(Connector.readObject("src\\Lab_5\\registeredTask.dat",Constructor.class));
        System.out.println(Connector.readObject("src\\Lab_5\\invoice.dat",Invoice.class));
        Squad[] employee1 = Connector.readSquad("src\\Lab_5\\squad.dat");
        for (Squad squad : employee1) {
            System.out.println(squad);
        }
    }
}
