import com.skillbox.airport.Terminal;

import java.util.*;

public class AirportMain {

    public static void main(String[] args) {
        List<Terminal> terminals = com.skillbox.airport.Airport.getInstance().getTerminals();

        // текущаю дата + 2 часа
        Calendar time = Calendar.getInstance();
        time.setTime(new Date());
        time.add(Calendar.HOUR, 2);

        terminals.stream().flatMap(t -> t.getFlights().stream())
                .filter(f -> f.getDate().before(time.getTime()))
                .filter(f -> f.getDate().after(new Date()))
                .forEach(System.out::println);

    }
}
