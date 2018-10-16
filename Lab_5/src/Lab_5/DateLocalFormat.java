package Lab_5;
import java.util.*;
import java.text.*;
public class DateLocalFormat {

    public static String getTimeStyle(Date now,Locale currentLocale) {
        DateFormat formatter = DateFormat.getTimeInstance(DateFormat.FULL, currentLocale);
        return formatter.format(now);
    }
}
