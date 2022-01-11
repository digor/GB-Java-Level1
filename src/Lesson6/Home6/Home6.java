package Lesson6.Home6;

public class Home6 {

    public static void main(String[] args) {
        String tempWinEvent = "it is ok";
        String tempLosEvent = "it is not ok";
        String eventName;
        String eventResult;

        Cat cat1 = new Cat("Tom", 5, 250);
        Cat cat2 = new Cat("Kiti", 5, 350);
        Dog dog1 = new Dog("Max", 15, 500);
        Dog dog2 = new Dog("Meg", 15, 350);

        Animal[] animals = {cat1, cat2, dog1, dog2};

        float runLength = 250;
        float swimLength = 8;

        for (int i = 0; i < animals.length; i++) {
            String typeAnimal = animals[i].getType() + " " + animals[i].getName() + " can";

            eventName = " run " + animals[i].getMaxRun() + " m. Traing to rum ";
            eventResult = animals[i].run(runLength) ? tempWinEvent : tempLosEvent;
            result(typeAnimal, eventName, runLength, eventResult);

            int swimRes = animals[i].swim(swimLength);
            eventName = " swim " + animals[i].getMaxSwim() + " m. Traing to swim ";
            eventResult = (swimRes == Animal.swim_ok) ? tempWinEvent : tempLosEvent;
            result(typeAnimal, eventName, runLength, eventResult);

            if(swimRes == Animal.swim_none){
                eventResult = " its fail, it is not swim";
            }
            result(typeAnimal, eventName, swimLength, eventResult);


        }
    }

    private static void result(String nameAnimal, String event, float eventLength, String resultEvent){
        System.out.println(nameAnimal + event + eventLength + " m and " + resultEvent);
    }
}


//  1. Создать классы Собака и Кот с наследованием от класса Животное.
//  2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
//  Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
//  3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
//  4. * Добавить подсчет созданных котов, собак и животных.
