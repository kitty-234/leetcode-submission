// Last updated: 2/5/2026, 9:20:22 PM
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11import java.util.*;
12class Solution {
13    public ListNode modifiedList(int[] nums, ListNode head) {
14
15        Set<Integer> set = new HashSet<>();
16        for (int num : nums) {
17            set.add(num);
18        }
19        ListNode dummy = new ListNode(0);
20        dummy.next = head;
21        ListNode curr = dummy;
22        while (curr.next != null) {
23            if (set.contains(curr.next.val)) {
24                curr.next = curr.next.next; // delete node
25            } else {
26                curr = curr.next;
27            }
28        }
29        return dummy.next;
30    }
31}
32