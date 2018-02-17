/**
 * @author Brandon D. Chen
 * @since 2/16/18
 * Instructor: Dong Si
 * CSS 143 A
 * Homework 6: Recursion
 * 
 * 
 */

public class LinearSearch extends SearchAlgorithm {
	public int search(String[] words, String wordToFind) throws ItemNotFoundException {
		for (int i = 0; i < words.length; i++) {
			incrementCount();
			if (wordToFind.equals(words[i])) {
				return getCount() - 1;
			}
		}
		throw new ItemNotFoundException();
	}
	
	public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException {
		int end = words.length - 1;
		if (words[getCount()].equals(wordToFind)) {
			int count = getCount();
			resetCount();
			return count;
		} else if (getCount() == end) {
			resetCount();
			throw new ItemNotFoundException();
		} else {
			incrementCount();
			return recSearch(words, wordToFind);
		}
	}

//	@Override
//	public int recSearch(String[] words, String wordToFind) {
//		return 0;
//	}
}
	
