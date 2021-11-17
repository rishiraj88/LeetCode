
/**
 * 
 * @author rishiraj
 * to find the length of the longest subsequence having only 1's
 * else to return 0
 *
 */
public class LcMaxConsecutiveOnes {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0 };
		System.out.println("findMaxConsecutiveOnes " + findMaxConsecutiveOnes(arr));
	}

	static int findMaxConsecutiveOnes(int[] nums) {
		int maxCount = 0;
		if(1 > nums.length) return maxCount;

		int count = nums[0];
		if(1 == nums.length) return count;		
		maxCount = count;
		
		for (int i = 1; i < nums.length; i++) {
			if (1 != nums[i]) {// nums[i]==0
				count = 0;
			} else {// nums[i]==1
				if (1 != nums[i - 1]) {
					count = 1;
				} else {
					count++;
				}
				maxCount = (count > maxCount) ? count : maxCount;
			}
		}
		return maxCount;
	}

}
