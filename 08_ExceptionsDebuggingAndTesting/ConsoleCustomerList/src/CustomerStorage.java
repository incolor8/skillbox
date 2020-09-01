import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerStorage
{
    private HashMap<String, Customer> storage;
    private final Pattern P = Pattern.compile("[+]?[0-9]{10,11}");

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws Throwable {
        String[] components = data.split("\\s+");
        String name = components[0] + " " + components[1];
        storage.put(name, new Customer(name, components[3], components[2]));
    
        Matcher m = P.matcher(components[3]);
        if(!components[2].contains("@")) {
            throw new MailException("Некоррктная почта! Повторите попытку.", components[2]);
        } else if(!m.find()) {
            throw new NumbException("Неверный формат телефона! Повторите попытку.", components[3]);
        }
    }

    public void listCustomers()
    {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name)
    {
        storage.remove(name);
    }

    public int getCount()
    {
        return storage.size();
    }
}