import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExperimentsFio {

    public String scanner;

    public ExperimentsFio(String scanner) {
        this.scanner = scanner;
        final String regex1 = "([а-яА-Яa-zA-Z]+)";
        final String regex2 = "([а-яА-Яa-zA-Z]+) ([а-яА-Яa-zA-Z]+)";
        final String regex3 = "([а-яА-Яa-zA-Z]+) ([а-яА-Яa-zA-Z]+) ([а-яА-Яa-zA-Z]+)";

        final Pattern pattern1 = Pattern.compile(regex1);
        final Pattern pattern2 = Pattern.compile(regex2);
        final Pattern pattern3 = Pattern.compile(regex3);
        final Matcher matcher1 = pattern1.matcher(scanner);
        final Matcher matcher2 = pattern2.matcher(scanner);
        final Matcher matcher3 = pattern3.matcher(scanner);

        if (matcher3.find()) {
            System.out.println("Фамилия: " + matcher3.group(1));
            System.out.println("Имя: " + matcher3.group(2));
            System.out.println("Отчетство: " + matcher3.group(3));
        } else if (matcher2.find()) {
            System.out.println("Фамилия: " + matcher2.group(1));
            System.out.println("Имя: " + matcher2.group(2));
        } else if (matcher1.find()) {
            System.out.println("Фамилия: " + matcher1.group(1));
        }

        /**
        while (true) {
            this.scanner = scanner;
            scanner = scanner.replaceAll("[^А-Яа-яA-Za-z ]", "");
            int wordsCount = scanner.split(" ").length;

            if (wordsCount > 3) {
                scanner = scanner.substring(0, scanner.lastIndexOf(" "));
            } else if (wordsCount == 1) {
                System.out.println("Фамилия: " + scanner);
                break;
            }

            String firstSpace = scanner.substring(0, scanner.indexOf(" "));
            String lastSpace = scanner.substring(scanner.indexOf(" "), scanner.lastIndexOf(" "));
            String lastSimbol = scanner.substring(scanner.lastIndexOf(" "));

            if (wordsCount == 3) {
                System.out.println("Фамилия: " + firstSpace + "\nИмя:" + lastSpace
                                 + "\nОтчетство:" + lastSimbol);
                break;
            } else if (wordsCount == 2) {
                System.out.println("Фамилия: " + firstSpace + "\nИмя:" + lastSimbol);
                break;
            }
        } */
    }
}

