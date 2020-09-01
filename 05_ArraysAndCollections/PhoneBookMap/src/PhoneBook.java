import java.util.*;
import java.util.regex.*;

public class PhoneBook {

    public static Map<String, String> name2phone = new TreeMap<>();

    public static Pattern pName = Pattern.compile("([\\D]+)\\s?([\\D]+)*\\s?([\\D]+)*\\s?([\\D]+)*");
    public static Pattern pPhone = Pattern.compile("([+7|8])\\s?\\(?([\\d+]){3}\\)?\\s?" +
            "([\\d]+\\s?[/-]?)*([\\d]+\\s?[/-]?)*([\\d]+\\s?[/-]?){7}");

    public static void main(String[] args) {
        name2phone.put("Alexey", "89539996741");

        System.out.println("Чтобы получить полный список, введите 'LIST'.");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите Имя или номер телефона: ");
            String input = scanner.nextLine();

            if (input.equals("EXIT")) {
                scanner.close();
                break;
            } else if (input.equals("LIST")) {
                printMap(name2phone);
                continue;
            }

            if (input.startsWith("8") || input.startsWith("+7")) {  // если поиск по номеру
                if (name2phone.containsValue(input)) {             // если инпут = номеру из мап
                    System.out.println("Имя: " + findKey(input) + " | Телефон: " + input);
                } else if (!name2phone.containsValue(input)) { // если не равен номеру
                    if (fieldPrinter(input).equals("PHONE")) { // проверяем формат номера
                        System.out.println("Не найдено. Чтобы добавить контакт, введите Имя: ");
                        String scanName = scanner.nextLine();
                        Matcher mScanName = pName.matcher(scanName);
                        if (mScanName.find() && !name2phone.containsKey(scanName)) {
                            // если новый инпут не равен имени в мап и проходит проверку по имени
                            name2phone.put(scanName, input);
                            System.out.println("Контакт добавлен.");
                        } else { // если в имени цифры
                            System.out.println("Очень интересное имя. Такое добавлять не будем");
                        }
                    } else {
                        System.out.println("Неверный формат номера!");
                    }
                }
            } else if (fieldPrinter(input).equals("NAME")) {   // проверяем формат имени
                if (name2phone.containsKey(input)) {              //если поиск по имени
                    String phone = name2phone.get(input);
                    System.out.println("Имя: " + input + " | Телефон: " + phone);
                } else if (!name2phone.containsKey(input)) { // если имя не в мапе
                    System.out.println("Не найдено. Чтобы добавить контакт, введите номер: ");
                    String number = new Scanner(System.in).nextLine();
                    Matcher mScanPhone = pPhone.matcher(number);
                    if (mScanPhone.find()) { // если имя проходит проверку
                        name2phone.put(input, number);
                        System.out.println("Контакт добавлен.");
                    } else {
                        System.out.println("Контакт не добавлен. Неверный формат номера!");
                    }    // если номер не подходит по формату
                }
            }
        }
    }

    // печатаем name2phone
    private static void printMap(Map<String, String> map) {
        for (String key : map.keySet()) {
            System.out.println(key + " => " + map.get(key));
        }
    }

    // находим имя по номеру
    private static String findKey(String phone) {
        for (Map.Entry<String, String> entry : PhoneBook.name2phone.entrySet()) {
            if (entry.getValue().equals(phone)) {
                return entry.getKey();
            }
        }
        return null;
    }

    private static String fieldPrinter(String input) {

        Matcher mName = pName.matcher(input);
        Matcher mPhone = pPhone.matcher(input);

        if (mPhone.find()) {
            return "PHONE";
        } else if (mName.find()) {
            return "NAME";
        } else {
            return "NotFound";
        }
    }
}