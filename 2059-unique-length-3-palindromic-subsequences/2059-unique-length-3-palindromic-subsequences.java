class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] first= new int[26];
        int[] last= new int[26];

        Arrays.fill(first, s.length());

        for(int i=0; i<s.length(); i++){
            int pos= s.charAt(i)-'a';
            first[pos]=Math.min(first[pos], i);
            last[pos]=i;
        }
        int res=0;
        for(int i=0; i<26; i++){
            if(first[i]<last[i]){
                res+=s.substring(first[i]+1,last[i]).chars().distinct().count();
            }
            
        } 
        return res;  
    }
}