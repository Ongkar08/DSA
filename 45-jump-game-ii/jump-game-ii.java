class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int ttl_jump = 0;
        int far = 0;
        int lastjump = 0;

        if (n == 1) return 0;

        for (int i = 0; i < n - 1; i++) {

            far = Math.max(far, i + nums[i]);

            if (i == lastjump) {
                ttl_jump++;
                lastjump = far;
            }
        }

        return ttl_jump;
    }
}