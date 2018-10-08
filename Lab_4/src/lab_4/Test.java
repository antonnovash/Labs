package lab_4;

import java.util.Arrays;

public class Test {
    static public void main(String[] args) {
        FuzzyNumber[] fuzzyNumbers = {
                new FuzzyNumber(0.8, 10, 0.2),
                new FuzzyNumber(0.2, 2, 0.3),
                new FuzzyNumber(0.3, 5, 0.4),
                new FuzzyNumber(0.4, 6, -0.1),
                new FuzzyNumber(0.5, -4, 0.6)
        };
        System.out.println("Исходный массив нечётких чисел:");
        for(FuzzyNumber e: fuzzyNumbers) {
            System.out.println(e.toString());
        }
        System.out.println("Сортировка нечётких чисел по x:");
        Arrays.sort(fuzzyNumbers);
        for(FuzzyNumber e: fuzzyNumbers) {
            for(Object object: e) {     // используем Iterator
                System.out.print(object + " ");
            }
            System.out.println();
        }
        System.out.println("Сортировка нечётких чисел по e1:");
        Arrays.sort(fuzzyNumbers,new FuzzyNumber.CompareToE1());
            for(FuzzyNumber e: fuzzyNumbers) {
                System.out.println(e.toString());
        }
        System.out.println("Сортировка нечётких чисел по e2:");
        Arrays.sort(fuzzyNumbers, new FuzzyNumber.CompareToE2()); //сортировка по e2
            for(FuzzyNumber e: fuzzyNumbers) {
                System.out.println(e.toString());
        }

        FuzzyNumber a = new FuzzyNumber(0.1,3,0.1);
        FuzzyNumber b = new FuzzyNumber(0.2,2,0.2);
        FuzzyNumber c;
        System.out.println("\nИспользуем данные нечёткие числа для показа работы методов:\n" +"a = " + a + "\nb = " + b);
        System.out.println("Сумма двух нечётких чисел:");
        c = a.addition(b);  // сумма
        System.out.println(c.toString());
        System.out.println("Разность двух нечётких чисел:");
        c = a.subtraction(b);  // разность
        System.out.println(c.toString());
        System.out.println("Произведение двух нечётких чисел:");
        c = a.multiplication(b);  // умножение
        System.out.println(c.toString());
        System.out.println("Частное двух нечётких чисел:");
        c = a.division(b);  // деление
        System.out.println(c.toString());
        System.out.println("обратное нечёткое число a:");
        c = a.reverse();  // обратное число
        System.out.println(c.toString());
        System.out.println("обратное нечёткое число b:");
        c = b.reverse();  // обратное число
        System.out.println(c.toString());

        String string = "-0.2 3 0.1";
        System.out.println("\nПокажем работу конструктора на примере строки" + string);
        FuzzyNumber stringConstructot= new FuzzyNumber(string);
        System.out.println(stringConstructot.toString());

    }
}
