package com.chainsys.collegefeeregister.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;

@Component
public class FileUtil {

	public static void writeToFile(String fileName, String content) throws IOException {

		Path path = Paths.get(fileName);
		byte[] bytes = content.getBytes();
		Files.write(path, bytes);
	}
}
