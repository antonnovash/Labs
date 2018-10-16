package Lab_5;

import java.io.*;

public class Connector {

    public static void writeTask(Task object,String filename) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOutputStream.writeObject(object);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Task readTask(String filename) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            return (Task) objectInputStream.readObject();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static void writeRegisteredTask(Constructor object,String filename) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOutputStream.writeObject(object);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Constructor readRegisteredTasks(String filename) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            return (Constructor) objectInputStream.readObject();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static void writeInvoice(Invoice object,String filename) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOutputStream.writeObject(object);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Invoice readInvoice(String filename) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            return (Invoice) objectInputStream.readObject();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static void writeSquad(Squad[] object, String filename) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOutputStream.writeObject(object);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Squad[] readSquad(String filename) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            Squad[] squads = (Squad[])objectInputStream.readObject();
            return squads;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


}
