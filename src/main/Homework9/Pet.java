package Homework9;

public class Pet {

    String name, type;    // имя, вид
    int age;              // возраст
    double weight;        // вес

    Pet()
    {
        type = "Собака";
        name = "Дружок";
        age = 3;
        weight = 5.2;
    }

    Pet(String t, String n)
    {
        type = t;
        name = n;
        age = 8;
    }

    Pet(String t, double w)
    {
        type = t;
        age = 2;
        weight = 1.5;
        this.name = "Мурзик";
    }

    void displayInfo(){
        System.out.printf("My pet: %s %s \tAge: %d \tWeight: %.2f\n", type, name, age, weight);
    }
}


