/*class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
       for(int i =0 ; i <=n ; i++){
        boolean found = false;
        for(int j =0 ; j < n; j++){
            if(nums[j] == i){
                found = true;
                break;

            }
        }
        if(!found){
            return i;
        }
       }
       return -1;
    }
}
*/
class Solution{
    public int missingNumber(int[] nums){
        int n = nums.length;
        int ttl_sum = n * (n + 1) / 2;
        int ini_sum = 0;
        for(int i = 0 ; i< n ;i++){
             ini_sum += nums[i];
        }
        return ttl_sum - ini_sum;
    }
}
