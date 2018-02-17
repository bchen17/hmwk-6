
/**
 * @author Brandon D. Chen
 * @since 2/16/18
 * Instructor: Dong Si
 * CSS 143 A
 * Homework 6: Recursion
 * 
 * FindFile recursively searches file directories until a max count is reached
 * 
 */

import java.io.*;
import java.util.*;

public class FindFile {
	private int max;
	private int count;
	private String[] locations;

	public FindFile(int maxFiles) {
		this.max = maxFiles;
		this.count = 0;
		this.locations = new String[this.max];
	}

	public void directorySearch(String target, String pathToStart) throws MaxFilesFoundException {
		File start = new File(pathToStart);
		if (!start.exists()) {
			throw new IllegalArgumentException("The given start directory is not valid");
		}
		
		File[] list = start.listFiles();
		
		if (list == null) {
			return;
		}

		for (int i = 0; i < list.length; i++) {
			if (count == max) {
				throw new MaxFilesFoundException();
			}
			if (list[i].getName().equals(target)) {
				locations[count] = list[i].getAbsolutePath();
				this.count++;
			} else if (list[i].isDirectory()) {
				directorySearch(target, list[i].getAbsolutePath());
			}
		}

	}

	public int getCount() {
		return this.count;
	}

	public String[] getFiles() {
		return this.locations;
	}

	public String toString() {
		String str = "Maximum file count reached. \nFiles found: ";
		if (count == 0)
			return str += "\nNo files found.";
		for (int i = 0; i < this.getFiles().length; i++) {
			if (this.getFiles()[i] != null) {
				str += "\n" + this.getFiles()[i];
			}
		}
		return str;
	}
}
