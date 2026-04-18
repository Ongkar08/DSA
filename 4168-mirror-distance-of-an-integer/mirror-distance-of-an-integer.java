class Solution {
    public int mirrorDistance(int n) {
        int mirror = 0, temp = n;
        while (temp > 0) {
            mirror = mirror * 10 + temp % 10;
            temp /= 10;
        }
        return Math.abs(mirror - n);
    }
}