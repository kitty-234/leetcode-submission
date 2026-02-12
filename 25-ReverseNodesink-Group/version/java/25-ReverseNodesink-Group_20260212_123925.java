// Last updated: 2/12/2026, 12:39:25 PM
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
11class Solution {
12    public ListNode reverseKGroup(ListNode head, int k) {
13        if (head == null || k == 1) return head;
14        ListNode dummy = new ListNode(0);
15        dummy.next = head;
16        ListNode prevGroupEnd = dummy;
17        while (true) {
18            ListNode kth = getKthNode(prevGroupEnd, k);
19            if (kth == null) break;
20            ListNode groupStart = prevGroupEnd.next;
21            ListNode nextGroupStart = kth.next;
22            ListNode prev = nextGroupStart;
23            ListNode curr = groupStart;
24            
25            while (curr != nextGroupStart) {
26                ListNode temp = curr.next;
27                curr.next = prev;
28                prev = curr;
29                curr = temp;
30            }
31            
32            prevGroupEnd.next = kth;
33            prevGroupEnd = groupStart;
34        }
35        return dummy.next;
36    }
37    private ListNode getKthNode(ListNode curr, int k) {
38        while (curr != null && k > 0) {
39            curr = curr.next;
40            k--;
41        }
42        return curr;
43    }
44}
45