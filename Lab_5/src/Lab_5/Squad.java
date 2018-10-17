package Lab_5;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Squad extends ObjectWithResourceBundle implements Serializable {
    private Squad[] employee;
    private String name;
    private Date date;
    transient public ResourceBundle resourceBundle = ResourceBundle.getBundle("Base");


    public Squad(String name, Locale locale) {
        this.name = name;
        this.date = new Date();
    }

    public Squad(Squad[] squads) {
        this.employee = squads;
    }

    public Squad[] getSquads() {
        return employee;
    }

    public void setSquads(Squad[] squads) {
        this.employee = squads;
    }

    @Override
    public String toString() {
        return resourceBundle.getString("squad") + '{' +
                resourceBundle.getString("name") + '\'' + name + '\'' +
                "} " + resourceBundle.getString("wasCreated")+ ": " + DateLocalFormat.getTimeStyle(date,Locale.getDefault());
    }
}
