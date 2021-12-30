package lesson3;

import java.util.Random;
import java.util.Arrays;

public class Lesson3 {
    public static Random random = new Random();

    public static void main(String[] args){
        int[] myArrayInt = new int[10];
        int[] myArrayInt2 = new int[100];
        int[] myArrayInt3 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        int[][] my2ArrayInt = new int[11][11];
        int[] myArrayInt6 = new int[20];
        int[] checkMyArray1 = {5, 8, 9, 0, 5, 9, 10};
        int[] checkMyArray2 = {1, 6, 8, 5, 0, 2, 13, 5};
        int[] checkMyArray3 = {5, 8, 9, 0};
        int[] checkMyArray4 = {0, 8, 9};
        int[] checkMyArray5 = {17, 0, 8, 9};

        System.out.println("\tЗадание 1");
        fillArray(myArrayInt, 2);
        readArray(myArrayInt);
        changeValueArray(myArrayInt);
        readArray(myArrayInt);

        System.out.println("\n\n\tЗадание 2");
        fillArray(myArrayInt2, 1);
        fillElementsOFArray(myArrayInt2);
        readArray(myArrayInt2);

        System.out.println("\n\n\tЗадание 3");
        readArray(myArrayInt3);
        findArray(myArrayInt3);
        readArray(myArrayInt3);

        System.out.println("\n\n\tЗадание 4");
        fillArray(my2ArrayInt);
        readArray(my2ArrayInt);

        System.out.println("\n\n\tЗадание 5");
        fillArray(10, 15);

        System.out.println("\n\n\tЗадание 6");
        fillArray(myArrayInt6, 30);
        readArray(myArrayInt6);
        maxMinElement(myArrayInt6);

        System.out.println("\n\n\tЗадание 7");
        readArray(checkMyArray1);
        System.out.println(" => " + checkBalance(checkMyArray1));
        readArray(checkMyArray2);
        System.out.println(" => " + checkBalance(checkMyArray2));
        readArray(checkMyArray3);
        System.out.println(" => " + checkBalance(checkMyArray3));
        readArray(checkMyArray4);
        System.out.println(" => " + checkBalance(checkMyArray4));
        readArray(checkMyArray5);
        System.out.println(" => " + checkBalance(checkMyArray5));
    }

//    1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
//       С помощью цикла и условия заменить 0 на 1, 1 на 0;
    public static void fillArray(int[] myArray, int rand){
        for(int i = 0; i < myArray.length; i++) {
            myArray[i] = random.nextInt(rand);
        }
    }

    public static void changeValueArray(int[] myArray){
        for(int i = 0; i < myArray.length; i++) {
            if(myArray[i] == 0){
                myArray[i] = 1;
            } else {
                myArray[i] = 0;
            }
        }
    }

//    2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
    public static void fillElementsOFArray(int[] myArray){
        for(int i = 0; i < myArray.length; i++){
            int b = i;
            myArray[i] = ++b;
        }
    }

//    3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static void findArray(int[] myArray){
        for(int i = 0; i < myArray.length; i++){
            if(myArray[i] < 6) {
                myArray[i] = myArray[i] * 2;
            }
        }
    }

//    4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
//    и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
//    Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
    public static void fillArray(int[][] myArray){
        for(int i = 0; i < myArray.length; i++) {
            for(int j = 0; j < myArray[i].length; j++){
                if(i == j || (i + j) == (myArray[i].length - 1)){
                    myArray[i][j] = 1;
                }
                else {
                    myArray[i][j] = 0;
                }
            }
        }
    }

//    5. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;
    public static void fillArray(int len, int initialValue){
        int[] myArray = new int[len];
        Arrays.fill(myArray, initialValue);
//        for(int i = 0; i < myArray.length; i++) {
//            myArray[i] = initialValue;
//        }
        readArray(myArray);
    }

//    6. * Задать одномерный массив и найти в нем минимальный и максимальный значения элементов;
    public static void maxMinElement(int[] myArray){
        int min = myArray[0];
        int max = myArray[0];

        for(int i = 0; i < myArray.length; i++){
            if(max < myArray[i]){
                max = myArray[i];
            }
            if(min > myArray[i]){
                min = myArray[i];
            }
        }

        System.out.println("\nmax = " + max + "\nmin = " + min);
    }
//    7. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
//        метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
//            Примеры:
//                checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) → true, т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
//                checkBalance([1, 1, 1, ||| 2, 1]) → true, т.е. 1 + 1 + 1 = 2 + 1
//                checkBalance([1, 1, 1, 8, 1]) → false
//                граница показана символами |||, эти символы в массив не входят и не имеют никакого отношения к ИЛИ.
    public static boolean checkBalance(int[] myArray){
        int half = 0; // задал границу между левой и правой части
        int rightSum = 0;
        int leftSum = 0;
        for (int i = 0; i < myArray.length; i++){
            if(myArray[i] == half) {
                for(int j = i; j < myArray.length; j++) {
                    rightSum += myArray[j];
                }
            }
                leftSum += myArray[i];

        }
        leftSum = leftSum - rightSum;
//        System.out.print("leftSum: " + leftSum + " rightSum: " + rightSum);
        return leftSum == rightSum;
    }

    public static void readArray(int[] myArray){
        System.out.println();
        for(int i = 0; i < myArray.length; i++) {
            System.out.print( myArray[i] +"  ");
        }
    }

    public static void readArray(int[][] myArray){
        System.out.println();
        for(int i = 0; i < myArray.length; i++) {
            for(int j = 0; j < myArray.length; j++)
                System.out.print( myArray[i][j] +"  ");
            System.out.println();
        }
    }

}
