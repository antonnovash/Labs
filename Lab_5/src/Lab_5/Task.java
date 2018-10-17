package Lab_5;

import java.io.Serializable;
import java.util.ResourceBundle;

public class Task extends ObjectWithResourceBundle  implements Serializable {
    private String description;
    //transient public ResourceBundle resourceBundle = ResourceBundle.getBundle("Base");

    public Task(String description) {

        this.description = description;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    @Override
    public String toString() {
        return resourceBundle.getString("taskForDescription") +
                '{' + resourceBundle.getString("description") +
                '\'' + description + '\'' + '}';
    }
}
