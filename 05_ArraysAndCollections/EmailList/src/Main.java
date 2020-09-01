import java.util.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        Set<String> emailList = new TreeSet<>();

        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.println("Введите е-мейл: ");
            String input = scanner.nextLine();

            Pattern pattern = Pattern.compile(".*@([a-zA-Z0-9]+)(\\.|_|-?)([a-zA-Z0-9])?(\\.[a-zA-Z]{2,63})");
            Matcher matcher = pattern.matcher(input);

            if (input.equals("LIST"))
            {
                printSet(emailList);

            } else if (input.equals("EXIT"))
            {
                scanner.close();
                break;
            } else if (!input.equals(""))
            {
                if(emailList.contains(input)) {
                    System.out.println("Такой емейл уже есть в списке - дубликаты не пройдут!");
                } else if (matcher.matches())
                {
                    emailList.add(input);
                    System.out.println("E-mail добавлен.");
                }  else {
                    System.out.println("Неверный формат ввода.");
                }
            }  else System.out.println("Программа пока что не умеет читать мысли - надо вводить.");
        }
    }

    private static void printSet(Set<String> set) {
        System.out.println("=============================");
        for (String item : set) {
            System.out.println(item);
        }
        System.out.println("=============================");
    }
}
