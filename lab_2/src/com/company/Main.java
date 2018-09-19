/*TASK #9
Ввести с консоли n - размерность матрицы a[n][n]. Задать
значения элементов матрицы в интервале значений от -n до n с
помощью датчика случайных чисел. Уплотнить матрицу, удаляя
из нее строки и столбцы, заполненные нулями. Распечатать
исходную матрицу и результат.*/

package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input the size of array: ");
        int N = in.nextInt();
        if (N < 1) {
            System.out.println("Invalid matrix size value ");
            System.exit(1);
        }
        int n = N, m = N;
        boolean p = false;
        int[][] array = new int[N][N];
        createArray(array, N);
        // зададим нулевую столбец и строку которые будут удалены.
        /*for(int j = 0; j < N; j++) {
            array[N - 2][j] = 0;
            array[j][N - 2] = 0;
        }*/
        System.out.println("Source array: ");
        printArray(array, N, N);
        // Удаляем строки заполненные 0
        for (int i = 0; i < n; i++) {
            p = true;
            for (int j = 0; j < m; j++) {
                if (array[i][j] != 0) {
                    p = false;
                    break;
                }
            }
            if (p) {
                for (int k = i; k < (n - 1); k++)
                    for (int j = 0; j < m; j++)
                        array[k][j] = array[k + 1][j];
                --i;
                --n;
            }
        }

        // Удаляем столбцы заполненные 0
        for (int j = 0; j < m; j++) {
            p = true;
            for (int i = 0; i < n; i++)
                if (array[i][j] != 0) {
                    p = false;
                    break;
                }
            if (p) {
                for (int k = j; k < (m - 1); k++)
                    for (int i = 0; i < m; i++)
                        array[i][k] = array[i][k + 1];
                --j;
                --m;
            }
        }
        System.out.println("New array: ");
        if (n == 0) {
            System.out.println("After the transformations made, the matrix became empty.");
            System.exit(1);
        }
        printArray(array, n, m);
    }

    private static void createArray(int[][] array, int n) {
        Random generator = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int) (-n + generator.nextInt(2 * n + 1));
            }
        }
    }

    private static void printArray(int[][] array, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%4d", array[i][j]);
            }
            System.out.println();
        }
    }
}