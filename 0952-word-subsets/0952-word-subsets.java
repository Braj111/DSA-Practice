class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        
        int[] freq= new int[26];
        for(String word: words2){
            int[] temp= new int[26];
            for(char w: word.toCharArray()){
                temp[w-'a']+=1;
            }
            for(int i=0; i<26; i++){
                freq[i]= Math.max(freq[i],temp[i]);
            }
        }

        for(String s: words1){
            int[] wfreq= new int[26];
            for(char c: s.toCharArray()){
                wfreq[c-'a']+=1;
            }

            boolean flag=true;
            for(int i=0; i<26; i++){
                if(freq[i]!=0 && wfreq[i]<freq[i]){
                    flag=false; break;
                }
            }
            if(flag) ans.add(s);
        }
        
       return ans;
    }
}