import java.util.*;
import java.util.concurrent.TimeUnit;

public class Generator {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        String[] chars = {"A", "B", "E", "K", "M", "H", "O", "P", "C", "T", "Y", "X"};

        for (int z = 0; z < chars.length; z++) {
            for (int r = 0; r < 200; r++) {
                for (int n = 0; n < 999; n += 111) {
                    for (int y = 0; y < chars.length; y++) {
                        for (int x = 0; x < chars.length; x++) {
                            String number = String.format("%s%d%s%s-%02d",
                                    chars[x], n, chars[y], chars[z], r);
                            list.add(number);
                        }
                    }
                }
            }
        }

        System.out.println(list.size());

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Input: ");
            String sc = scanner.nextLine();

            HashSet<String> hashSet = new HashSet<>();
            hashSet.addAll(list);

            TreeSet<String> treeSet = new TreeSet<>();
            treeSet.addAll(list);

            long startList = System.nanoTime();

            list.contains(sc);

            long durationList = System.nanoTime() - startList;
            if (list.contains(sc)) {
                System.out.println("Поиск перебором: номер найден, поиск занял " + durationList + " нс");
            } else System.out.println("Поиск перебором: номер не найден, поиск занял " + durationList + " нс");

            long startBinarySearch = System.nanoTime();

            Collections.binarySearch(list, sc);

            long durationBinarySearch = System.nanoTime() - startBinarySearch;
            if (Collections.binarySearch(list, sc) != 0) {
                System.out.println("Бинарный поиск: номер найден, поиск занял " + durationBinarySearch + " нс");
            } else System.out.println("Бинарный поиск: номер не найден, поиск занял " + durationBinarySearch + " нс");

            long startHash = System.nanoTime();

            hashSet.contains(sc);

            long durationHash = System.nanoTime() - startHash;
            if (hashSet.contains(sc)) {
                System.out.println("Поиск в HashSet: номер найден, поиск занял " + durationHash + " нс");
            } else System.out.println("Поиск в HashSet: номер не найден, поиск занял " + durationHash + " нс");

            long startTree = System.nanoTime();

            treeSet.contains(sc);

            long durationTree = System.nanoTime() - startTree;
            if (treeSet.contains(sc)) {
                System.out.println("Поиск в TreeSet: номер найден, поиск занял " + durationTree + " нс");
            } else System.out.println("Поиск в TreeSet: номер не найден, поиск занял " + durationTree + " нс");
        }
    }
}
