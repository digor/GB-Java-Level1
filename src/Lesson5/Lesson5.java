package Lesson5;

public class Lesson5 {
    public static void main(String[] args) {

        Employee[] persArray = {
                new Employee("Igor Dabija", "Manager", "igor@work.ru", "+373 66 66 66", 30000, 1980),
                new Employee("Vasilii Pupkin", "Courier", "vasilii@work.ru", "+373 66 66 65", 9000, 1995),
                new Employee("Vladimir McFilin", "Seller", "vladimir@work.ru", "+373 66 66 64", 30000, 1977),
                new Employee("Mihai Stratulat", "Storekeeper", "idab@work.ru", "+373 66 66 61", 30000, 2000),
                new Employee("Varvara Putin", "Courier", "idab@work.ru", "+373 66 66 60", 30000, 1986)
        };

        System.out.println("All men");
        getEmployee(persArray);

        System.out.println("\nList old men");
        getEmployee(persArray, 30);
    }

    public static void getEmployee(Employee[] persArray){
        for (int i = 0; i < persArray.length; i++){
                System.out.println(persArray[i].infoEmployee());
        }
    }

    public static void getEmployee(Employee[] persArray, int age){
        for (int i = 0; i < persArray.length; i++){
            if(persArray[i].getEmployeeAge() > age)
                System.out.println(persArray[i].infoEmployee());
        }
    }
}

/**
 * На JAVA НЕ!!!! ПИШУТ на русском языке *
 * 1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
 * 2. Конструктор класса должен заполнять эти поля при создании объекта.
 * 3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
 * 4. Создать массив из 5 сотрудников.
 * Пример:
 * Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
 * persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
 * 5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
 */
