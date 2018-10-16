package Lab_5;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;

public class Squad implements Serializable {
    private Squad[] squads;
    private String name;
    private Locale locale;
    private Date date;

    public Squad(String name,Locale locale) {
        this.name = name;
        this.locale = locale;
        this.date = new Date();
    }

    public Squad(Squad[] squads) {
        this.squads = squads;
    }

    public Squad[] getSquads() {
        return squads;
    }

    public void setSquads(Squad[] squads) {
        this.squads = squads;
    }

    @Override
    public String toString() {
        return "Squad{" +
                "name='" + name + '\'' +
                '}'+ " Was created: " + DateLocalFormat.getTimeStyle(date,locale);
    }
}
