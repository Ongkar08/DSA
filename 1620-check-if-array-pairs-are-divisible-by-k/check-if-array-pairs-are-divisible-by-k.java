class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] freq = new int[k];
        for(int i = 0; i< arr.length;i++){
            int rem = ((arr[i] % k ) + k) % k;
            freq[rem]++;
        }
        if(freq[0] % 2 != 0){
            return false;
        }
        for(int r =1;r< k; r++){
            if(r==k-r){
                if(freq[r] % 2!= 0){
                    return false;
                }
            }else{
                if(freq[r] != freq[k-r]){
                    return false;
                }
            }
        }
        return true;

        
    }
}