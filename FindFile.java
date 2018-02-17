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
	
	public void directorySearch(String target, String dirName) throws ItemNotFoundException {
		File name = new File(dirName);
		String[] fileList = name.list();
		for (int i = 0; i < fileList.length; i++) {
			String newFile = dirName + "\\" + fileList[i];
			File aFile = new File(newFile);
			if (aFile.isDirectory()) {
				directorySearch(target, newFile);
			} else {
				throw new ItemNotFoundException();
			}
		}
		
		
		
	}
	
	public int getCount() {
		return this.count;
	}
	
	public String[] getFiles() {
		return this.locations;
	}
}
