// Last updated: 2/12/2026, 12:35:52 PM
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
11import java.util.PriorityQueue;
12class Solution {
13    public ListNode mergeKLists(ListNode[] lists) {
14        if (lists == null || lists.length == 0) return null;
15        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
16            (a, b) -> a.val - b.val
17        );
18        for (ListNode node : lists) {
19            if (node != null) {
20                minHeap.offer(node);
21            }
22        }
23        ListNode dummy = new ListNode(0);
24        ListNode current = dummy;
25        while (!minHeap.isEmpty()) {
26            ListNode smallest = minHeap.poll();
27            current.next = smallest;
28            current = current.next;
29            if (smallest.next != null) {
30                minHeap.offer(smallest.next);
31            }
32        }
33        return dummy.next;
34    }
35}
36