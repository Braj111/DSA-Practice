class Solution {
    public boolean canConstruct(String s, int k) {
        if(k>s.length()) return false;
        if(k==s.length()) return true;
        
        int[] arr= new int[26];
        for(char ch:s.toCharArray()){
            arr[ch-'a']++;
        }
        int odd=0;
        for(int i=0;i<26; i++){
            if(arr[i]%2!=0) odd++;
        }
        
        return odd<=k;
    }
}