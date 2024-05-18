package ds.misc;

import java.util.HashMap;
import java.util.Map;

public class RomanNumerals {
	public static void main(String[] args) {
		Map<Character, Integer> mapping = getNumberMapping();
		String roman = "MCMXCIV";
		int length = roman.length();
		int prev = 0;
		int value = 0;
		
		for (int i = length - 1; i >= 0; i--) {
			int currVal = mapping.get(roman.charAt(i));
			value += currVal;

			if (prev < currVal) {
				value -= (2 * prev);
			}
			
			prev = currVal;
		}
		
		System.out.println(value);
	}
	
    private static Map<Character, Integer> getNumberMapping() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        return map;
    }
}
