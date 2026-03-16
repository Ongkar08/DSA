class Solution {
    public int alternatingSum(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(i%2!=0){
                nums[i]*=-1;
            }
            sum+=nums[i];
        }
        return sum;
    }
}