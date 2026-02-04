// Last updated: 2/4/2026, 12:57:29 PM
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> ans=new HashSet<>();
        ListNode temp1=headA;
        ListNode temp2=headB;
        while(temp1!=null){
            ans.add(temp1);
            temp1=temp1.next;
        }
        while(temp2 !=null){
            if(ans.contains(temp2)==true){
                return temp2;
            }
            temp2=temp2.next;
        }
        return null;

    }
}