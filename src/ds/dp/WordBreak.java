package ds.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string of only lower case letters and no spaces and a dictionary which contains a set of words, 
 * compute how many ways the given sentence can be broken into valid words of the dictionary.
 * 
 * @author tausif.farooqi
 *
 */
public class WordBreak {
	private static final List<String> DICT = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");

	public static void main(String[] args) {
		// result = 3
		final String s = "pineapplepenapple";
		final List<String> sentence = new ArrayList<>();
		
		System.out.println("Count -> " + breakWords(0, s, sentence, 0));

	}

	private static int breakWords(int start, String s, List<String> sentence, int count) {
		if (start >= s.length() - 1) {
			System.out.println(sentence);
			return ++count;
		}
		
		for (int i = start + 1; i <= s.length(); i++) {
			String word = s.substring(start, i);
			if (DICT.contains(word)) {
				sentence.add(word);
				count = breakWords(i, s, sentence, count);
				sentence.remove(word);
			}
		}
		
		return count;
	}
}
