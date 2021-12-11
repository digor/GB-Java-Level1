package Lesson2;

public class lesson2 {
    public static void main(String[] args){

//         1. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно),
//            если да – вернуть true, в противном случае – false.
        System.out.println("============ 1 ============");
        System.out.println("Сумма " + (checkNumbers(10, 5) ? "" : "не ") + "в пределах от 10 до 20");
        System.out.println("Сумма " + (checkNumbers(10, -55) ? "" : "не ") + "в пределах от 10 до 20");
        System.out.println("Сумма " + (checkNumbers(13, 55) ? "" : "не ") + "в пределах от 10 до 20");

//        2. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль, положительное ли число передали или отрицательное.
//           Замечание: ноль считаем положительным числом.
        System.out.println("============ 2 ============");
        System.out.println("Число " + (isPositive(5) ? "положительное " : "отрицательное"));
        System.out.println("Число " + (isPositive(0) ? "положительное " : "отрицательное"));
        System.out.println("Число " + (isPositive(-6) ? "положительное " : "отрицательное"));

//        3. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
        System.out.println("============ 3 ============");
        System.out.println("Число " + (isNegative(5) ? "отрицательное " : "положительное"));

//        4. Написать метод, которому в качестве аргументов передается строка и число, метод должен отпечатать в консоль указанную строку, указанное количество раз;
        System.out.println("============ 4 ============");
        printStringCount("Salut",5);

//        5.* Написать метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true, не високосный - false).
//            Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
        System.out.println("============ 5 ============");
        int currYear = 100;
        System.out.println("Год " + currYear + " " + (leapYar(currYear) ? "високосный " : "не високосный"));
        currYear = 98;
        System.out.println("Год " + currYear + " " + (leapYar(currYear) ? "високосный " : "не високосный"));
        currYear = 2104;
        System.out.println("Год " + currYear + " " + (leapYar(currYear) ? "високосный " : "не високосный"));
    }

    public static boolean checkNumbers(int a, int b){
        return (a + b >= 10) && (a + b <= 20);
    }

    public static boolean isPositive(int a){
        return a >= 0;
    }

    public static boolean isNegative(int a){
        return a <= 0;
    }

    public static void printStringCount(String word, int count){
        for(int i = 1; i <= count; i++) {
            System.out.println(i + ". " + word);
        }
    }

    public static boolean leapYar(int year){
        return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
    }
}
