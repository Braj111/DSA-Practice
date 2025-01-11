class Solution {
    public boolean canConstruct(String s, int k) {
        if(k>s.length()) return false;
        if(k==s.length()) return true;
        
        int[] arr= new int[26];
        for(int i=0; i<s.length(); i++){
            arr[s.charAt(i)-'a']+=1;
        }
        int even=0, odd=0;
        for(int i=0;i<26; i++){
            if(arr[i]!=0){
                if(arr[i]%2==0)even++;
                else odd++;
            }
        }
        // System.out.println(even+" "+odd);
        if(odd>k) return false;
        //  System.out.println(even+" "+odd);
        return true;
    }
}