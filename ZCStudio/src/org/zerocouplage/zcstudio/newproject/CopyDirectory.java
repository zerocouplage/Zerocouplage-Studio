package org.zerocouplage.zcstudio.newproject;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;




/**
 * @author Doaae K
 *
 */
class CopyDirectory extends SimpleFileVisitor<Path> {

	private Path source;
	private Path target;

	public CopyDirectory(Path source, Path target) {
		this.source = source;
		this.target = target;
	}
      
	/* (non-Javadoc)
	 * @see java.nio.file.SimpleFileVisitor#visitFile(java.lang.Object, java.nio.file.attribute.BasicFileAttributes)
	 */
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attributes)
			throws IOException {
		//afficher la traitement effectuer au log
		System.out.println("Copying " + source.relativize(file));
		Files.copy(file, target.resolve(source.relativize(file)));
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult preVisitDirectory(Path directory,
			BasicFileAttributes attributes) throws IOException {
		Path targetDirectory = target.resolve(source.relativize(directory));
		try {
			System.out.println("Copying " + source.relativize(directory));
			Files.copy(directory, targetDirectory);
		} catch (FileAlreadyExistsException e) {
			if (!Files.isDirectory(targetDirectory)) {
				throw e;
			}
		}
		return FileVisitResult.CONTINUE;
	}
}