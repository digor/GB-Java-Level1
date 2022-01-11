package Lesson5;

public class Employee {
    public String fullName;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int birthYear;
    private static int currentYear = 2021;

    public Employee(String fullName, String position, String email, String phone, int salary, int birthYear){
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.birthYear = birthYear;
    }

    int getEmployeeAge(){
        return currentYear - birthYear;
    }


    String infoEmployee(){
        return this.fullName
                + " \t| " + "age: " + this.getEmployeeAge()
                + " \t| " + this.position
                + " \t| email: " + this.email
                + " \t| phone: " + this.phone
                + " \t| salary: " + this.salary;
    }
}
