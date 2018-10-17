package Lab_5;

import java.io.*;
import java.util.ResourceBundle;

public class Connector {

    public static void writeObject(Object object,String filename) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOutputStream.writeObject(object);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T extends ObjectWithResourceBundle> Object readObject(String filename, Class<T> klass) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            ObjectWithResourceBundle task = klass.cast(objectInputStream.readObject());
            task.resourceBundle = ResourceBundle.getBundle("Base");
            return task;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Squad[] readSquad(String filename) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            Squad[] squads = (Squad[])objectInputStream.readObject();
            for(int i = 0; i < squads.length; i++) {
                squads[i].resourceBundle = ResourceBundle.getBundle("Base");
            }
            return squads;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}