/*Задание №9.Используйте класс Scanner для построчного чтения
стандартного входного потока до конца файла, результат
выводится в стандартный выходной поток. Для каждых двух
входных строк найти и напечатать общую подстроку наибольшей
длины.
*/
package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner input;
        File file = new File("Text.txt");
        try {
            input = new Scanner(file);
            while(input.hasNextLine()){
                String str1 = input.nextLine();
                String str2 = input.nextLine();
                CompareLengthAndOutputResults(str1, str2);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void FindSubstr(String str1, String str2) {
        String subStr;
        String result = "";
        int maxLength = 0;
        for( int i = 1,j = 0; i <= str1.length(); i++) {
            subStr = (str1.substring(j,i));
            boolean isContainSubString = str2.contains(subStr);
            if(isContainSubString ) {
                if(maxLength < subStr.length()) {
                    result=subStr;
                    maxLength = subStr.length();
                }
            }
            else {
                j++;
                i = j;
            }
        }
        System.out.println("The search substring: " + result);
    }
    public static void CompareLengthAndOutputResults(String str1, String str2) {
        if( str1.length() < str2.length() ) {
            FindSubstr(str1, str2);
        }
        else {
            FindSubstr(str2, str1);
        }
    }
}

