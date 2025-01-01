class Solution {
    public int maxScore(String s) {
        int res=0;
        
        int[] pre = new int[s.length()];
        for(int i=s.length()-1; i>=0; i--){
            if(i==s.length()-1){
                if(s.charAt(i)=='1') pre[i]=1;
            } 
            else if(s.charAt(i)=='1') pre[i]=pre[i+1]+1;
            else pre[i]=pre[i+1];
            
        }
        // System.out.println(Arrays.toString(pre));
        int zero=0;
        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i)=='0') zero++;
            res=Math.max(res, zero+pre[i+1]);
        }
        return res;
    }
}