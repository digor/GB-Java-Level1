package Lesson6.Home6;

public class Dog extends Animal{
    public int countDog = 0;
    public static String thisClas = "Dog";

    public Dog(String name, float maxRun, float maxSwim) {
        super(thisClas, name, maxRun, maxSwim);
    }
}
