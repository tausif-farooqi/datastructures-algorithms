package ds.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatsAndDogs {
	private static final List<String> DICT = Arrays.asList("cat", "cats", "and", "sand", "dog");

	public static void main(String[] args) {
		String input = "catsanddog";
		List<String> words = new ArrayList<String>();
		findWords(input, 0, words);

	}
	
	private static void findWords(String input, int start, List<String> words) {
		if (start > input.length() - 1) {
			System.out.println("Sentence -> " + words);
			return;
		}
		
		for (int i = start; i < input.length(); i++) {
			String word = input.substring(start, i + 1);
			
			if (DICT.contains(word)) {
				words.add(word);
				findWords(input, i + 1, words);
				words.remove(words.size() - 1);
			}
		}
	}

}
