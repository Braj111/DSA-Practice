class Solution {
    public boolean vowel(char c){
        return c=='a'|c=='e'|c=='i'|c=='o'|c=='u';
    }
    public long countOfSubstrings(String word, int k) {
        return f(word,k)-f(word,k+1);
    }
    public long f(String word, int k){
        long ans=0;
        int left=0;
        int nonV=0;
        Map<Character, Integer> hm= new HashMap<>(5);

        for(char c:word.toCharArray()){
            if(vowel(c)) hm.merge(c,1,Integer::sum);
            else nonV++;
            
            while(nonV>=k && hm.size()==5){
                char d=word.charAt(left++);
                if(vowel(d)) {if(hm.merge(d,-1,Integer::sum)==0) hm.remove(d);}
                else nonV--;
            }
            ans+=left;
        }
        return ans;
    }
}