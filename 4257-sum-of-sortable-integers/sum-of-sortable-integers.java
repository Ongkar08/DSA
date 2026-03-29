class Solution {

    private boolean operation(int k, int[] nums) {
        int n = nums.length;
        int chunks = n / k;

        int[][] minMax = new int[chunks][2];

        for (int i = 0; i < chunks; i++) {
            int start = i * k;

            int mini = Integer.MAX_VALUE;
            int maxi = Integer.MIN_VALUE;
            int cnt = 0;

            for (int j = 0; j < k; j++) {
                int curr = nums[start + j];
                int next = nums[start + (j + 1) % k];

                mini = Math.min(mini, curr);
                maxi = Math.max(maxi, curr);

                if (curr > next) cnt++;
            }

            if (cnt > 1) return false;

            minMax[i][0] = mini;
            minMax[i][1] = maxi;
        }

        for (int i = 0; i < chunks - 1; i++) {
            if (minMax[i][1] > minMax[i + 1][0]) {
                return false;
            }
        }

        return true;
    }

    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (operation(i, nums)) ans += i;

                if (i != n / i) {
                    if (operation(n / i, nums)) ans += (n / i);
                }
            }
        }

        return ans;
    }
}