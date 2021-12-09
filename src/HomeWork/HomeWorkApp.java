package HomeWork;

public class HomeWorkApp {
    public static void main(String[] args){
        System.out.println("========== 2 ==========");
        printThreeWords();

        System.out.println("========== 3 ==========");
        if(checkSumSign(10, -35)) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }

        System.out.println("========== 4 ==========");
        System.out.println(printColor(6));
        System.out.println(printColor(-6));
        System.out.println(printColor(106));

        System.out.println("========== 5 ==========");
        System.out.println(compareNumbers(6, 6));
        System.out.println(compareNumbers(-6, 10));
        System.out.println(compareNumbers(10,6));
    }

    public static void printThreeWords(){
        System.out.println("Orange\nBanana\nApple");
    }

    public static boolean checkSumSign(int a, int b){
        return (a + b) >= 0;
    }

    public static String printColor(int value){
        if(value <= 0) {
            return "Red";
        } else if (value > 0 && value <= 100){
            return "Yellow";
        } else {
            return "Green";
        }
    }

    public static String compareNumbers(int a, int b){
        if(a >= b) {
            return "a >= b";
        } else {
            return "a < b";
        }
    }
}
