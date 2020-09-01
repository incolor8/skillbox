import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
//        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy - EEEE");
//        Calendar calendar = Calendar.getInstance();
//
//        int a = 0;
//        for (int i = 1992; i <= 2020; i++, a++) {
//            calendar.set(Calendar.YEAR, i);
//            System.out.println(a + " - " + dateFormat.format(calendar.getTime()));
//        }

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy - EEEE", new Locale("ru"));

        LocalDate birthday = LocalDate.of(1992, 3, 5);
        LocalDate today = LocalDate.now();

        int a = 0;
        for (int i = 0; i <= today.getYear() - birthday.getYear(); i++, a++) {
            System.out.println(a + " - " + dateFormat.format(birthday.plusYears(i)));
        }
    }
}
