package Homework9;

public class Pet {

    String name, type;    // имя, вид
    int age;              // возраст
    double weight;        // вес

    Pet()
    {
        this("Собака", "Дружок");
        this.age = 5;
        this.weight = 10;
    }

    Pet(String t, String n)
    {
        this.type = t;
        this.name = n;
        this.age = 8;
        this.weight = 5.2;
    }

    Pet(String n)
    {
        this("Кошка", "Мурзик");
        this.age = 9;
        this.weight = 6.0;
    }

    void displayInfo() {
        System.out.printf("My pet: %s %s \tAge: %d \tWeight: %.2f\n", type, name, age, weight);
    }
}


