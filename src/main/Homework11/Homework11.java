package Homework11;

public class Homework11 {
    public static void main(String[] args) {
        char q1 = '\u055A';
        String str = "Я помню чудное мгновение";
        String str1 = "Передо мной явилась ты";
        String str2 = "Как мимолетное видение";
        String str3 = "Как гений чистой красоты!";
        System.out.println("\"" + "\n" + str + "\n" + "\"" + "\n"+ str1 + "\n"+ "\"" + "\n"+ str2 + "\n" + "\"" + "\n" + str3);

        String str4 = "Java -";
        String str5 = "лучший";
        String str6 = "язык";
        String str7 = "программирования!";
        System.out.println("\""+ "\n" +  str4 + " " + str5+ " " + str6+ " " + str7);

        String textLang ="Обожаю изучать новые языки";
        int start = 7;
        int end = 14;
        char[] dst = new char[end-start];
        textLang.getChars(start,end, dst, 0);
        int start1 = 7;
        int end1 = 26;
        char[] dst1 = new char[end1-start1];
        textLang.getChars(start1,end1, dst1, 0);
        System.out.println(dst);
        System.out.println(dst1);

        String textIndex ="Домашнее задание не проблема";
        int index1 = textIndex.indexOf("не");
        int index2 = textIndex.lastIndexOf("не");
        System.out.println(index1);
        System.out.println(index2);
    }
}

