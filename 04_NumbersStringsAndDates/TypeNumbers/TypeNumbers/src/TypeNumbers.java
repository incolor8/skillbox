import java.util.Scanner;

public class TypeNumbers {
    public static void main(String[] args) {
//      Целые
        System.out.println("byte max: " + Byte.MAX_VALUE + " min: " + Byte.MIN_VALUE);
        System.out.println("int max: " + Integer.MAX_VALUE + " min: " + Integer.MIN_VALUE);
        System.out.println("short max: " + Short.MAX_VALUE + " min: " + Short.MIN_VALUE);
        System.out.println("long max: " + Long.MAX_VALUE + " min: " + Long.MIN_VALUE);
        System.out.println();
//      С плавающей точкой
        System.out.println("float max: " + Float.MAX_VALUE + " min: " + (-Float.MAX_VALUE));
        System.out.println("double max: " + Double.MAX_VALUE + " min: " + (-Double.MAX_VALUE));
        System.out.println();
//      Минимальный тип для целого числа
//        Scanner in = new Scanner(System.in);
//        System.out.println("Введите число:");
//        var number = in.nextLong();
//
//        if (number >= -128 && number <= 127) {
//            System.out.println("This number is type - byte.");
//        } else if (number >= -32768 && number <= 32767) {
//            System.out.println("This number is type - short.");
//        } else if (number >= -2147483648 && number <= 2147483647) {
//            System.out.println("This number is type - int.");
//        } else { System.out.println("This number is type - long"); }
    }
}
