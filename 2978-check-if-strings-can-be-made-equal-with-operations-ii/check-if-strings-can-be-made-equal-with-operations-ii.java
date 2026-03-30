class Solution {
    public boolean checkStrings(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        int[] counEven = new int[26];
        int[] counOdd = new int[26];
        for(int i = 0; i< s1.length(); i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (i % 2 ==0){
                counEven[c1 - 'a']++;
                counEven[c2 - 'a']--;
            }
            else{
                counOdd[c1-'a']++;
                counOdd[c2 - 'a']--;

            }

        }
        for(int i =0; i < 26; i++){
            if(counEven[i] != 0 || counOdd[i] != 0){
                return false;

            }
        }
        return true;
        
    }
}