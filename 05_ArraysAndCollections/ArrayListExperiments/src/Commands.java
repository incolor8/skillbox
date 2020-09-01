import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Commands {
    private static ArrayList<String> todoList = new ArrayList<>() {{
        add("Первое дело");
        add("Второе дело");
        add("Третье дело");
        add("Четвертое дело");
    }};

    private static CommandsList commandsList = new CommandsList();

    public void execute(String command) {

        Pattern pattern = Pattern.compile("([A-Z]+)\\s+(\\d*)\\s*(\\D?.*)");
        Matcher matcher = pattern.matcher(command);

        if (matcher.find()) {

            String index = matcher.group(2);
            String todoListElement = matcher.group(3);

            if (!index.equals("")) {

                int indexInt = Integer.parseInt(index);

                if (command.startsWith(commandsList.add)) {
                    add(index, todoListElement);
                } else if (command.startsWith(commandsList.edit)) {
                    edit(indexInt, todoListElement);
                } else if (command.startsWith(commandsList.delete)) {
                    delete(indexInt);
                } else {
                    System.out.println("Такого элемента не существует.");
                }
            } else if (command.startsWith(commandsList.add)) {
                    addElementOnly(todoListElement);
            } else if (command.startsWith(commandsList.delete)) {
                delElementOnly(todoListElement);
            } else {
                System.out.println("Неверная команда.");
            }
        }
        if (command.startsWith(commandsList.help)) {
            help(command);
        } else if (command.startsWith(commandsList.list)) {
            list(command);
        }
    }

    private static void add(String index, String todoElement) {
        if (Integer.parseInt(index) < todoList.size()) {
            todoList.add(Integer.parseInt(index), todoElement);
            System.out.println("Элемент '" + todoElement + "' добавлен в список на " + index + " индекс.");
        }
    }

    private static void addElementOnly(String todoElement)
    {
        todoList.add(todoElement);
        System.out.println("Элемент '" + todoElement + "' добавлен в список");
    }

    private static void list(String cmd) {
        if (cmd.startsWith("LIST")) {
            for (int i = 0; i < todoList.size(); i++) {
                System.out.println(i + 1 + " - " + todoList.get(i));
            }
        }
    }

    private static void edit(int index, String todoElement) {
        todoList.set(index - 1, todoElement);
        System.out.println(index + " элемент изменен.");
    }

    private static void delete(int index) {
        todoList.remove(index - 1);
        System.out.println("Элемент " + index + " удален.");
    }

    private static void delElementOnly(String todoElement)
    {
        todoList.remove(todoElement);
        System.out.println("Элемент '" + todoElement + "' удален.");
    }

    private static void help(String commandHelp)
    {
        if (commandHelp.equals(commandsList.help))
        {
            System.out.println("Список команд" +
                "\n=================================================================" +
                "\n*\tLIST - введите эту команду, чтобы получить все элементы списка." +
                "\n*\tADD - введите эту команду, чтобы добавить элемент в список." +
                "\n*\tEDIT - введите эту команду, чтобы редактировать какой-либо элемент списка." +
                "\n*\tDELETE - введите эту команду, чтобы удалить элемент из списка." +
                "\n*\tEXIT - введите эту команду, чтобы завершить работу." +
                "\n=================================================================");
        }
    }
}

