package controller;

import java.io.File;

public class SearchController {
	public void searchFiles(String directory, String extension) {
		File fileDirectory = new File(directory);
		File[] fileList = fileDirectory.listFiles();
		
		if (fileList != null) {
			for (File file : fileList) {
				if (file.isFile()) {
					if (file.getPath().endsWith(extension)) {
						System.out.println("File found! - " + file.getPath() + "\n");
					}
				} else {
					searchFiles(file.getPath(), extension);
				}
			}
		}
	}
}