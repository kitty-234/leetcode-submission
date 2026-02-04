// Last updated: 2/4/2026, 12:57:20 PM
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // Step 1: Find the middle of the linked list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the linked list
        ListNode secondHalf = reverseList(slow);

        // Step 3: Compare the first half with the reversed second half
        ListNode firstHalf = head;
        ListNode temp = secondHalf; // Store for restoration
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                reverseList(temp); // Restore list before returning
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // Step 4: Restore the original list (optional but good practice)
        reverseList(temp);
        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null, next = null, curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}