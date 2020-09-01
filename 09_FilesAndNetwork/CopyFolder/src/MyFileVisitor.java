import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class MyFileVisitor extends SimpleFileVisitor<Path> {
	private Path fromPath;
	private Path toPath;
	private StandardCopyOption copyOption = StandardCopyOption.REPLACE_EXISTING;

	public MyFileVisitor(Path fromPath, Path toPath) {
		this.fromPath = fromPath;
		this.toPath = toPath;
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		Path targetPath = toPath.resolve(fromPath.relativize(dir));
		if(!Files.exists(targetPath)){
			Files.createDirectory(fromPath);
		}
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		Files.copy(file, toPath.resolve(fromPath.relativize(file)), copyOption);
		return FileVisitResult.CONTINUE;
	}
}