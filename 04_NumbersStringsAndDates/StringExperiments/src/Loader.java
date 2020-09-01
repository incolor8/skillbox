import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loader
{
    public static  void main(String[] args) {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

//        int vasyaAmount = Integer.parseInt(text.substring(15).substring(0, 4)); // заработал Вася
//        int petyaAmount = Integer.parseInt(text.substring(35).substring(0, 4)); // заработал Петя
//        int mashaAmount = Integer.parseInt(text.substring(56).substring(0, 5)); // заработала Маша
//
//        System.out.println(vasyaAmount + petyaAmount + mashaAmount);
//
        //с регулярным выражением
//        String[] arroyText = text.split(",\\s+");
//
//        int sum = 0;
//        for (String someoneAmound : arroyText)
//            sum += Integer.parseInt(someoneAmound.replaceAll("[^0-9]", ""));
//
//        System.out.println(sum);

        final Pattern pattern = Pattern.compile("([0-9]+)");
        final Matcher matcher = pattern.matcher(text);

        int sum = 0;
        while (matcher.find()) {
            sum += Integer.parseInt(matcher.group());
        }
        System.out.println(sum);
    }
}