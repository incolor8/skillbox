import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Чтобы просмотреть список всех комманд введите 'HELP'.");
        Scanner scanner = new Scanner(System.in);
        Commands commands = new Commands();

        while (true) {
            System.out.println("Введите команду: ");
            String command = scanner.nextLine();
            commands.execute(command);
            if (command.equals(new CommandsList().exit))
            {
                System.out.println("Завершение");
                scanner.close();
                break;
            }
        }
    }
}

