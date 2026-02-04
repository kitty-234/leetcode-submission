// Last updated: 2/4/2026, 12:56:54 PM
class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
        return nums;
    }
    void mergeSort(int[] a, int l, int r, int[] tmp) {
        if (l >= r) return;
        int m = (l + r) / 2;
        mergeSort(a, l, m, tmp);
        mergeSort(a, m + 1, r, tmp);
        merge(a, l, m, r, tmp);
    }
    void merge(int[] a, int l, int m, int r, int[] tmp) {
        int i = l, j = m + 1, k = l;
        while (i <= m && j <= r) tmp[k++] = (a[i] < a[j]) ? a[i++] : a[j++];
        while (i <= m) tmp[k++] = a[i++];
        while (j <= r) tmp[k++] = a[j++];
        for (i = l; i <= r; i++) a[i] = tmp[i];
    }
}

   

