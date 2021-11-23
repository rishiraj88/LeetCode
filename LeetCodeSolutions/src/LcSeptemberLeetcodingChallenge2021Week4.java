package leetcode;
/**
 * WIP code
 * @author rishiraj
 * to get the maximum length of possible words made with the segments provided in input arrays,
 * with the condition that no letters in the words must be repeated anyhow.
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//september-leetcoding-challenge-2021/639/week-4
/**
 * 
 * @author dem Maximum Length of a Concatenated String with Unique Characters
 * 
 *         You are given an array of strings arr. A string s is formed by the
 *         concatenation of a subsequence of arr that has unique characters.
 * 
 *         Return the maximum possible length of s.
 * 
 *         A subsequence is an array that can be derived from another array by
 *         deleting some or no elements without changing the order of the
 *         remaining elements.
 * 
 *         Example 1:
 * 
 *         Input: arr = ["un","iq","ue"] Output: 4 Explanation: All the valid
 *         concatenations are "","un","iq","ue","uniq" and "ique". Maximum
 *         length is 4.
 * 
 *         Example 2:
 * 
 *         Input: arr = ["cha","r","act","ers"] Output: 6 Explanation: Possible
 *         solutions are "chaers" and "acters".
 * 
 *         Example 3:
 * 
 *         Input: arr = ["abcdefghijklmnopqrstuvwxyz"] Output: 26
 * 
 *         Constraints:
 * 
 *         1 <= arr.length <= 16 1 <= arr[i].length <= 26 arr[i] contains only
 *         lower case English letters.
 * 
 *         Hint 1: You can try all combinations and keep mask of characters you
 *         have.
 * 
 *         Hint 2: You can use DP.
 * 
 * 
 * 
 */
public class LcSeptemberLeetcodingChallenge2021Week4 {
	public static void main(String[] args) {
		List<String> arr = Arrays.asList("un", "iq", "ue");// 4 //unique
		// System.out.println(maxLength(arr));

		arr = Arrays.asList("abcdefghijklmnopqrstuvwxyz"); // 26
		// System.out.println(maxLength(arr));

		arr = Arrays.asList("cha", "r", "act", "ers"); // 6
		// System.out.println(maxLength(arr));

		arr = Arrays.asList("yy", "bkhwmpbiisbldzknpm"); // 0
		// System.out.println(maxLength(arr));

		arr = Arrays.asList("a", "abc", "d", "de", "def"); // 6
		System.out.println(maxLength(arr));

	}

	static public int maxLength(List<String> arr) {

		int maxLength = 0;

		String mask = arr.stream().flatMapToInt(c -> c.chars()).distinct().mapToObj(i -> (char) i)
				.collect(Collectors.toSet()).stream().sorted().map(c -> "" + c).collect(Collectors.joining(""));

		System.out.println("mask: " + mask);
		String maskOrig = mask;

		for (int outerIndex = 0; outerIndex < arr.size(); outerIndex++) { // loop1: outer loop

			String outString = "";
			int maskCount = 0;
			loop2: for (int indexInList = outerIndex; indexInList < arr.size(); indexInList++) { // loop2: inner loop
				System.out.println("indexInList: "+ indexInList +"; "+arr.get(indexInList ));
				boolean allCharsNew = true;
				String charsCheckedInThisSting = "";
				boolean isSimilar = false;
				if (0 < indexInList) {
					for (int prevIndex = 0; prevIndex < indexInList; prevIndex++) {

						if (arr.get(indexInList).contains(arr.get(prevIndex))
								&& outString.contains(arr.get(prevIndex))) {
							isSimilar = true;
							System.out.println("prevIndex: " + prevIndex);
							System.out.println("prevIndex + arr.get(prevIndex): " + prevIndex + arr.get(prevIndex));
							System.out.println("prevIndex + arr.get(prevIndex).length(): "
									+ (prevIndex + arr.get(prevIndex).length()));
							outString = new StringBuilder(outString)
									.replace(outString.indexOf(arr.get(prevIndex)),
											(outString.indexOf(arr.get(prevIndex)) + arr.get(prevIndex).length()), "")
									.toString();
							mask = mask.replaceAll("_", "").concat(arr.get(prevIndex));
							mask = mask.chars().distinct().sorted().mapToObj(i -> (char) i).map(c -> "" + c)
									.collect(Collectors.joining(""));
						}
					}
				}
				for (char ch : arr.get(indexInList).toCharArray()) { // String looping
					if (charsCheckedInThisSting.contains(ch + "")) {
						return 0;
					}
					charsCheckedInThisSting += ch;
					if (outString.contains(ch + "")) {
						allCharsNew = false;
						continue;
					} else {
						mask = mask.replace(ch, '_');
						maskCount++;
						System.out.println("mask: " + mask + "; maskCount: " + maskCount);
					}
				} // "a", "abc", "d", "de", "def"
				if (allCharsNew) {
					outString += arr.get(indexInList);
					System.out.println("outString: " + outString + "; size: " + outString.length());
					maxLength = (outString.length() > maxLength) ? outString.length() : maxLength;
				}

			} // end of for (int indexInList = 0;
			mask = maskOrig;
		} // end of loop1

		return maxLength;
	}
}
