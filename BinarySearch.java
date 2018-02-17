/**
 * @author Brandon D. Chen
 * @since 2/16/18
 * Instructor: Dong Si
 * CSS 143 A
 * Homework 6: Recursion
 * 
 * 
 */

public class BinarySearch extends SearchAlgorithm {
	public int search(String[] words, String wordToFind) throws ItemNotFoundException {
		int low = 0;
		int high = words.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (wordToFind.equals(words[mid])) {
				return mid;
			} else if (wordToFind.compareTo(words[mid]) < 0) {
				high = mid - 1;
			} else if (wordToFind.compareTo(words[mid]) > 0) {
				low = mid + 1;
			}
		}
		throw new ItemNotFoundException();
	}
	
	public int recSearch(String[] words, String wordToFind, int low, int high) throws ItemNotFoundException {
		if (low > high) {
			throw new ItemNotFoundException();
		} else {
			int mid = (low + high) / 2;
			if (words[mid].compareTo(wordToFind) < 0) {
				return recSearch(words, wordToFind, mid + 1, high);
			} else if (words[mid].compareTo(wordToFind) > 0) {
				return recSearch(words, wordToFind, low, mid - 1);
			} else {
				return mid;
			}
		}
	}

	@Override
	public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException {
		return 0;
	}
}
