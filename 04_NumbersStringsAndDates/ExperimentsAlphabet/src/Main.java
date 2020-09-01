import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        String alphabet = "abcdefgehijklmnopqrstuvwxyzABCDEFGEHIJKLMNOPQRSTUVWXYZ";
//        String alphabetRu = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя";

//        for (int i = 0; i < alphabet.length(); i++) {
//            char simbol = alphabet.charAt(i);
//            System.out.println(simbol + ": " + (int) simbol);
//        }

        System.out.println("Введите ФИО:");
        Scanner in = new Scanner(System.in);
        String scanner = in.nextLine();
        ExperimentsFio fio = new ExperimentsFio(scanner);
        in.close();

    }
}
