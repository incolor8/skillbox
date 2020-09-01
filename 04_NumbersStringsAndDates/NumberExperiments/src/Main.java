import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите номер телефона:");
        Scanner in = new Scanner(System.in);
        String number = in.nextLine();
        ExperimentsNumber phone = new ExperimentsNumber(number);
        in.close();
    }
    public static class ExperimentsNumber {
        public String number;

        public ExperimentsNumber(String number) {
            this.number = number;
            number = number.replaceAll("(\\D)*", "");
                if (number.length() >= 10) {
                    number = number.substring(number.length() - 10);
                    number = "+7" + " (" + number.substring(0, 3) + ") " + number.substring(3, 6) + "-"
                            + number.substring(6, 8) + "-" + number.substring(8);
                } else {
                    System.out.print("Cлишком короткий номер: ");
                }
                System.out.println(number);
        }
    }
}
