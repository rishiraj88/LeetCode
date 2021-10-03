

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author rishiraj
 * 
 *         Longest Substring Without Repeating Characters - LeetCode
 *         https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 *         Given a string s, find the length of the longest substring without
 *         repeating characters.
 */
public class LcNonRepeatingSubstring {
	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s));

		s = "bbbbb";
		System.out.println(lengthOfLongestSubstring(s));

		s = " ";
		System.out.println(lengthOfLongestSubstring(s) + " for space");

		s = "   ";
		System.out.println(lengthOfLongestSubstring(s) + " for spaces");

		s = "";
		System.out.println(lengthOfLongestSubstring(s) + " for zero string");

		s = null;
		System.out.println(lengthOfLongestSubstring(s));

		s = "pwwkew";
		System.out.println(lengthOfLongestSubstring(s));

		s = "au";
		System.out.println(lengthOfLongestSubstring(s));

		s = "dvdf";
		System.out.println(lengthOfLongestSubstring(s));

		s = "loddktdji";
		System.out.println(lengthOfLongestSubstring(s));

		s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWX...";
		System.out.println(lengthOfLongestSubstring(s));

	}

	public static int lengthOfLongestSubstring(String s) {
		// handling special cases
		if (null == s) {
			return 0;
		} else {
			System.out.println(s);
		}
		if (0 == s.length() || 1 == s.length()) {
			return s.length();
		}

		// General workflow
		Set<StringBuilder> setOfNonRepeatingCharSequences = new HashSet<>();

		for (int j = 0; j < s.length() - 1; j++) {
			StringBuilder newCharSequence = new StringBuilder("" + s.charAt(j));
			for (int indexInInputString = j+1; indexInInputString < s.length(); indexInInputString++) {
				if (newCharSequence.toString().contains("" + s.charAt(indexInInputString))) {
					newCharSequence = new StringBuilder("" + s.charAt(indexInInputString));
				} else {
					newCharSequence.append(s.charAt(indexInInputString));
				}
				setOfNonRepeatingCharSequences.add(newCharSequence);
			}
		}
		int len = 0;
		for (StringBuilder sb : setOfNonRepeatingCharSequences) {
			if (sb.length() > len)
				len = sb.length();
		}
		return len;
	}
}

/* "abcabcbb"
	"    "
	""
	" "
	"loddktdji"
	"dvdf"
	"au"
	"fdf"
	"fdfdd"
	"fdfdfsfsdf"
	"pwwkew"
	"bbbbbb"	
	*/