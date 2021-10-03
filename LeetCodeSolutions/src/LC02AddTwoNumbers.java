

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author rishiraj
 * 		
 * You are given two non-empty linked lists representing two
 *         non-negative integers. The digits are stored in reverse order, and
 *         each of their nodes contains a single digit. Add the two numbers and
 *         return the sum as a linked list.
 * 
 *         You may assume the two numbers do not contain any leading zero,
 *         except the number 0 itself.
 *  
 *         Example 1:
 * 
 *         Input: l1 = [2,4,3], l2 = [5,6,4] Output: [7,0,8] Explanation: 342 +
 *         465 = 807.
 * 
 *         Example 2:
 * 
 *         Input: l1 = [0], l2 = [0] Output: [0]
 * 
 *         Example 3:
 * 
 *         Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] Output: [8,9,9,9,0,0,0,1]
 * 
 *         Constraints:
 * 
 *         The number of nodes in each linked list is in the range [1, 100]. 0
 *         <= Node.val <= 9 It is guaranteed that the list represents a number
 *         that does not have leading zeros.
 * 
 *         Accepted 1,936,035 Submissions 5,382,951
 */
public class LC02AddTwoNumbers {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3))); // 342
		ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4))); // 465
		System.out.println(new LC02AddTwoNumbers().addTwoNumbers(l1, l2)); // 807

		l1 = new ListNode(9,
			new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));// 9_999_999
		l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))); // 9_999
		System.out.println(new LC02AddTwoNumbers().addTwoNumbers(l1, l2));// 10_009_998

		l1 = new ListNode(1, new ListNode(8));// 81
		l2 = new ListNode(0); // 0
		System.out.println(new LC02AddTwoNumbers().addTwoNumbers(l1, l2));// 81
		
		l1 = new ListNode(9, new ListNode(1, new ListNode(6))); // 619
		l2 = new ListNode(0); // 0
		System.out.println(new LC02AddTwoNumbers().addTwoNumbers(l1, l2));// 619

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode ret = new ListNode();
		ListNode retNum = ret;

		retNum = add(ret, l1, l2);

		return retNum;
	}

	public ListNode add(ListNode ans, ListNode l1, ListNode l2) {
		ans = null == ans ? new ListNode() : ans;
		if (null != l1) {
			ans.val += l1.val;
		}
		if (null != l2) {
			ans.val += l2.val;
		}

		if (9 < ans.val) {
			ans.next = new ListNode();
			ans.next.val = ans.val / 10;
			ans.val %= 10;
			if (null != l1)
				l1.next = (null == l1.next) ? new ListNode() : l1.next;
			if (null != l2)
				l2.next = (null == l2.next) ? new ListNode() : l2.next;
		}

		if (null == ans.next && ((null == l1 || null == l1.next) && (null == l2 || null == l2.next)))
			return ans;

		return new ListNode(ans.val, add(ans.next, 
				null == l1 ? null : l1.next, null == l2 ? null : l2.next));

	}

}

/**
 * 
 * Definition for singly-linked list.
 *
 */
class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {
		ListNode n = this;
		List<Integer> ar = new ArrayList<Integer>();

		do {
			ar.add(n.val);
			n = n.next;
		} while (null !=  n);

		return ar.stream().map(i -> i.toString()).collect(Collectors.joining(","));

	}
}
