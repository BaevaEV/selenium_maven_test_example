package Homework8;

public class Homework8 {
    public static void main(String[] args) {
        float fl = 876.351f;
        int i = 7778;
        String a = "Игорь";
        char ch = 110;
        char ch2 = 121;
        boolean itsTrue = true;

        System.out.println("Значение целочисленной переменной"+"-"+ i);
        System.out.println("Значение дробной переменной с плавающей точкой"+"-"+fl);
        System.out.println("Значение строковой переменной "+"-"+ a);
        System.out.println("Значение символьной переменной "+"-"+ ch+ch2);
        System.out.println("Значение булевой переменной "+"-"+ itsTrue);

        int b = (int) fl;
        System.out.println("Значение дробной переменной с плавающей точкой заменила на целочисленное"+"-"+b);
        float h = (float) i;
        System.out.println("Значение целочисленной переменной заменила на float"+"-"+ h);
    }
}