// Last updated: 2/4/2026, 12:56:43 PM
import java.util.*;

class Solution {
    static class Node {
        long val;
        int idx;
        Node prev, next;
        Node(int i, long v) {
            idx = i;
            val = v;
        }
    }
    
    static class Pair implements Comparable<Pair> {
        long sum;
        int leftIdx;
        Pair(long s, int li) {
            sum = s;
            leftIdx = li;
        }
        public int compareTo(Pair o) {
            if (sum != o.sum) return Long.compare(sum, o.sum);
            return Integer.compare(leftIdx, o.leftIdx);
        }
    }
    
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;
        
        Node[] nodes = new Node[n];
        TreeSet<Pair> pairSet = new TreeSet<>();
        int decCount = 0;
        
        Node prevNode = null;
        for (int i = 0; i < n; i++) {
            Node node = new Node(i, nums[i]);
            nodes[i] = node;
            if (prevNode != null) {
                node.prev = prevNode;
                prevNode.next = node;
                long pSum = prevNode.val + node.val;
                pairSet.add(new Pair(pSum, prevNode.idx));
                if (prevNode.val > node.val) decCount++;
            }
            prevNode = node;
        }
        
        int ops = 0;
        while (decCount > 0 && !pairSet.isEmpty()) {
            Pair minPair = pairSet.pollFirst();
            Node left = nodes[minPair.leftIdx];
            Node right = left.next;
            if (right == null || left.val + right.val != minPair.sum) {
                continue;
            }
            ops++;
            
            if (left.val > right.val) decCount--;
            
            long oldLeftVal = left.val;
            left.val += right.val;
            
            Node rightNext = right.next;
            if (rightNext != null) {
                if (right.val > rightNext.val) decCount--;
            }
            
            left.next = rightNext;
            if (rightNext != null) {
                rightNext.prev = left;
                if (left.val > rightNext.val) decCount++;
                long newSum = left.val + rightNext.val;
                pairSet.add(new Pair(newSum, left.idx));
            }
            
            Node pLeft = left.prev;
            if (pLeft != null) {
                boolean oldPDec = (pLeft.val > oldLeftVal);
                if (oldPDec) decCount--;
                boolean newPDec = (pLeft.val > left.val);
                if (newPDec) decCount++;
                long newPSum = pLeft.val + left.val;
                pairSet.add(new Pair(newPSum, pLeft.idx));
            }
            
            right.prev = right.next = null;
        }
        return ops;
    }
}
