import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class CheckAndCopy {
	private static final Path copyFolder = Path.of("res/newFolder");

	public static void execute(String path) {

		Path p = new File(path).toPath();
		
		MyFileVisitor visitor = new MyFileVisitor(p, copyFolder);

		try {
			Files.walkFileTree(p, visitor);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
