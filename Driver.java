/**
 * @author Brandon D. Chen
 * @since 2/16/18
 * Instructor: Dong Si
 * CSS 143 A
 * Homework 6: Recursion
 * 
 * 
 */
public class Driver {
	private static final int MAX_NUMBER_OF_FILES_TO_FIND = 3;

	/**
	 * @param args. not used
	 * @throws FoundFilesException, if max files is found, it stops the program and prints the output.
	 */
	public static void main(String args[]){
		String targetFile = "Metamorphosis Essay.docx";
		String pathToSearch ="/Users/LJAndrea/Documents/HNA/";
		FindFile finder = new FindFile(MAX_NUMBER_OF_FILES_TO_FIND);
		try{ 
			finder.directorySearch(targetFile, pathToSearch);
		}
		catch(MaxFilesFoundException e){
			System.out.println(finder.toString());
		}
	}
}