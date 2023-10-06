
import java.util.*;

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

	public int[] twoSumFast(int[] nums, int target) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int i= 0;i<nums.length;i++) {
			Integer deficitIndex = map.get(nums[i]); // assuming nums[i] to be the deficit for another number in nums array
			if(null != deficitIndex) {
				return new int[]{i,deficitIndex};
			} else {
				map.put(target - nums[i],i);
			}
		}
		return new int[]{-1,-1};
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
		Random random = new Random();
		int[] a1 = new int[1000000];
		for(int i=0;i<a1.length;i++){
			a1[i]=random.nextInt(50000);
		}

		//slower algorithm
		long start = System.currentTimeMillis();
		System.out.println(Arrays.toString(new LC01TwoSum().twoSumSlow(new int[] { 2, 5, 5, 11 }, 10)));
		long mid1 = System.currentTimeMillis();
		System.out.println("Time to find a pair: " +(mid1-start));

		System.out.println(Arrays.toString(new LC01TwoSum().twoSumSlow(new int[] { 3, 2, 4, -2, 8 }, 6)));
		long mid2 = System.currentTimeMillis();
		System.out.println("Time to find a pair: " +(mid2-mid1));

		System.out.println(Arrays.toString(new LC01TwoSum().twoSumSlow(a1, 6)));
		long end = System.currentTimeMillis();
		System.out.println("Time to find a pair: " +(end-mid2));

		//faster algorithm
		start = System.currentTimeMillis();
		System.out.println(Arrays.toString(new LC01TwoSum().twoSumSlow(new int[] { 2, 5, 5, 11 }, 10)));
		mid1 = System.currentTimeMillis();
		System.out.println("Time to find a pair: " +(mid1-start));

		System.out.println(Arrays.toString(new LC01TwoSum().twoSumSlow(new int[] { 3, 2, 4, -2, 8 }, 6)));
		mid2 = System.currentTimeMillis();
		System.out.println("Time to find a pair: " +(mid2-mid1));

		System.out.println(Arrays.toString(new LC01TwoSum().twoSumSlow(a1, 6)));
		end = System.currentTimeMillis();
		System.out.println("Time to find a pair: " +(end-mid2));

	}
}

/* One output listing
		[1, 2]
		Time to find a pair: 1
		[1, 2]
		Time to find a pair: 4
		[888, 6192]
		Time to find a pair: 619
		[1, 2]
		Time to find a pair: 0
		[1, 2]
		Time to find a pair: 1
		[888, 6192]
		Time to find a pair: 241
*/