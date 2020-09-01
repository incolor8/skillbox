import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	private static StringBuilder file;
	private static long sumSize;
	
	public static void main(String[] args) {
		try {
			System.out.println("Введите путь к папке: ");
			String sc = new Scanner(System.in).nextLine();
			if (sc.equals(" ")) {
				file = new StringBuilder(args[0]);
			} else {
				file = new StringBuilder(args[0]).append("/" + sc);
			}
			if (Paths.get(file.toString()).toFile().exists()) {
				Files.walk(Paths.get(file.toString()))
						.map(file -> Files.isDirectory(file) ?
								file.getFileName().toString() + "/" :
								file.getFileName().toString()).collect(Collectors.toList())
						.forEach(f -> sumSize += f.length());
				System.out.println("Размер вложенных файлов: " + getHumanReadableSize(sumSize));
			} else {
				System.out.println("Неверный путь.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getHumanReadableSize(long size) {
		String[] SIZE_MULTIPLIERS = {"B", "Kb", "Mb", "Gb", "Tb"};
		
		for (int i = 0; i < SIZE_MULTIPLIERS.length; i++) {
			double value = ((double) size) / Math.pow(1024, i);
			
			if (value < 1024) {
				return Math.round(value * 1000) / 1000. + " " +
						SIZE_MULTIPLIERS[i];
			}
		}
		return "Более 1 PiB!";
	}
}
