
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author rishiraj
 *         Given an array of integers nums and an integer target, return indices
 *         of the two numbers such that they add up to target.
 *         You may assume that each input would have exactly one solution, and
 *         you may not use the same element twice.
 *         You can return the answer in any order.
 * 
 *         Example 1:
 * 
 *         Input: nums = [2,7,11,15], target = 9
 *         Output: [0,1]
 *         Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * 
 *         Example 2:
 * 
 *         Input: nums = [3,2,4], target = 6
 *         Output: [1,2]
 * 
 *         Example 3:
 * 
 *         Input: nums = [3,3], target = 6
 *         Output: [0,1]
 * 
 *         Constraints:
 * 
 *         2 <= nums.length <= 104
 *         -109 <= nums[i] <= 109
 *         -109 <= target <= 109
 *         Only one valid answer exists.
 * 
 * 
 *         Follow-up: Can you come up with an algorithm that is less than O(n2)
 *         time complexity?
 *         Accepted
 *         4,243,384
 *         Submissions
 *         9,043,632
 */
public class LC01TwoSum {

	//{ 2, 5, 5, 11 }, target = 10
	//    ,3  ,2 

	public int[] twoSumSlow(int[] nums, int target) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int i= 0;i<nums.length;i++) {
			if(nums[i]+)
		}
	}

	public int[] twoSumSlow(int[] nums, int target) {
		int[] retArr = { -1, -1 };
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j > i && j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		return retArr;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(Arrays.toString(new LC01TwoSum().twoSumSlow(new int[] { 2, 5, 5, 11 }, 10)));
		long end = System.currentTimeMillis();
		System.out.println(Arrays.toString(new LC01TwoSum().twoSumSlow(new int[] { 3, 2, 4, -2, 8 }, 6)));
		end = System.currentTimeMillis();

		System.out.println(Arrays.toString(new LC01TwoSum().twoSumFast(new int[] { 2, 5, 5, 11 }, 10)));
		end = System.currentTimeMillis();
		System.out.println(Arrays.toString(new LC01TwoSum().twoSumFast(new int[] { 3, 2, 4, -2, 8 }, 6)));
		end = System.currentTimeMillis();
	}
}