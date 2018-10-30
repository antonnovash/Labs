package Lab_7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    public static void main(String args[]) throws ParseException {
        ArrayList<Record> magazine = new ArrayList<>();
        createArrayList(magazine);
        Map<Object,Long> map = Buffer.write(magazine);
        SortedMap sortedMap = new TreeMap(map);

        System.out.println("\nNot sorted magazine:");
        printMap(map);
        System.out.println("\nSort by key:(\'ownerName\')");
        printMap(sortedMap);

        System.out.println();
        System.out.println("Вывод объекта,находящегося ниже заданного");
        System.out.println(Buffer.moveLow(magazine.get(1).getOwnerName(), map));
        System.out.println("Вывод объекта,находящегося выше заданного");
        System.out.println(Buffer.moveUp(magazine.get(1).getOwnerName(), map));

        System.out.println("Remove by index");
        Buffer.removeByIndex(magazine.get(0).getOwnerName(), map);
        for (var entry : map.entrySet()) {
            Record record = Buffer.read(entry.getKey(),map);
            if (record != null) {
                System.out.println("Key: " + entry.getKey());
                System.out.println(Buffer.read(entry.getKey(), map));
            }
        }
    }

    private static void createArrayList(ArrayList<Record> magazine) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Record firstRecord = new Record("9012AB-1","Ivan Ivanov",simpleDateFormat.parse("24.10.2018 10:00:00"),simpleDateFormat.parse("30.10.2018 18:00:00"),"250$");
        Record secondRecord = new Record("1234AB-5","Anton Novash",simpleDateFormat.parse("22.10.2018 11:00:00"),simpleDateFormat.parse("26.10.2018 11:30:00"),"150$");
        Record thirdRecord = new Record("5678AB-7","Artur Ysnov",simpleDateFormat.parse("23.10.2018 12:00:00"),simpleDateFormat.parse("28.10.2018 12:30:00"),"200$");

        magazine.add(firstRecord);
        magazine.add(secondRecord);
        magazine.add(thirdRecord);
    }
    private static <K,V> void printMap(Map<K, V> map) {
        System.out.println("______________________________________");
        for(Map.Entry<K,V> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey());
            System.out.println(Buffer.read(entry.getKey(), (Map<Object, Long>) map));
        }
    }
}
