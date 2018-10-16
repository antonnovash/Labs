package Lab_5;

import java.util.Random;
import java.util.Locale;
import java.util.ResourceBundle;

public class Test {

    public static void main(String args[]) throws Exception {

        Task task = new Task("Build a five-story house.");
        Constructor constructor = new Constructor();
        Customer customer = new Customer(1000000);
        Invoice invoice = constructor.coastProject(task);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Base",new Locale(args[0],args[1]));

        Locale[] locales = {
                new Locale("be","BY"),
                new Locale("ru","RU"),
                new Locale("en","US"),
        };
        // Create Squard
        String[] employeeNames = {"Anton","Alex","Max","Slava","Vadim","Egor","Kate","Masha","Nikita"};
        Squad[] squads = constructor.createSquad(task);
        Random random = new Random();
        for(int i = 0; i < squads.length; i++) {
            squads[i] = new Squad(employeeNames[random.nextInt(9)],locales[2]);
        }

        Connector.writeTask(task,"src\\Lab_5\\task.dat");
        Connector.writeRegisteredTask(constructor,"src\\Lab_5\\registeredTask.dat");
        Connector.writeInvoice(invoice,"src\\Lab_5\\invoice.dat");
        Connector.writeSquad(squads,"src\\Lab_5\\squad.dat");

        System.out.println(resourceBundle.getString("mode"));
        System.out.println(Connector.readTask("src\\Lab_5\\task.dat").toString());
        System.out.println(Connector.readRegisteredTasks("src\\Lab_5\\registeredTask.dat").registerTask(invoice,customer));
        System.out.println(Connector.readInvoice("src\\Lab_5\\invoice.dat"));
        Squad[] squads1 = Connector.readSquad("src\\Lab_5\\squad.dat");
        for (Squad squad : squads1) {
            System.out.println(squad);
        }
    }

}
