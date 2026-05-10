class Solution {
    public boolean canReach(int[] arr, int start) {
        if (start < 0 || start >= arr.length || arr[start] < 0) {
            return false;
        }
        if (arr[start] == 0) {
            return true;
        }
        int jumpValue = arr[start];
        arr[start] = -arr[start];
        return canReach(arr, start + jumpValue) || canReach(arr, start - jumpValue);
    }
}