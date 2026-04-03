class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int x = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] == target) x++;
                int len = j - i + 1;
                if (x > len / 2) count++;
            }
        }
        return count;
    }
}