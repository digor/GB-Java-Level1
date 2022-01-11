package Lesson6.Home6;

public class Cat extends Animal{

    public int countCat = 0;
    public static String thisClas = "Cat";

    public Cat(String name, float maxRun, float maxSwim) {
        super(thisClas, name, maxRun, maxSwim);
    }

    @Override
    protected int swim(float dist){
        return Animal.swim_none;
    }
}
