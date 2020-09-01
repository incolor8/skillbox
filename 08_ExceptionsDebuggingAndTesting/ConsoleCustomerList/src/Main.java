import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main
{
    private static String addCommand = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static String commandExamples = "\t" + addCommand + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static String commandError = "Wrong command! Available command examples: \n" +
            commandExamples;
    private static String helpText = "Command examples:\n" + commandExamples;

    public static void main(String[] args) throws Throwable {
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();
        System.out.println("Введите команду: ");
        for(;;)
        {
            String command = scanner.nextLine();
            String[] tokens = command.split("\\s+", 2);
            
            try {
                if (tokens[0].equals("add")) {
                    addException(command, 5);
                    executor.addCustomer(tokens[1]);
                } else if (tokens[0].equals("list")) {
                    addException(command, 1);
                    executor.listCustomers();
                } else if (tokens[0].equals("remove")) {
                    addException(command, 3);
                    executor.removeCustomer(tokens[1]);
                } else if (tokens[0].equals("count")) {
                    addException(command, 1);
                    System.out.println("There are " + executor.getCount() + " customers");
                } else if (tokens[0].equals("help")) {
                    addException(command, 1);
                    System.out.println(helpText);
                } else {
                    System.out.println(commandError);
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public static void addException(String cmd, int countElements) throws CmdException {
        String[] elements = cmd.split(" ");
        if (elements.length != countElements) {
            throw new CmdException("Неверное количество элементов!" +
                    " Повторите попытку.", elements[0]);
        }
    }
}
