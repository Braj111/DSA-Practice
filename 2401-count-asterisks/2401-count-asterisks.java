class Solution {
    public int countAsterisks(String s) {
        int res=0;
        int b=0;

        int count=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='|'){
                b++;
                if(b%2==0){
                    count=0;
                    continue;
                }else{
                    res+=count;
                    count=0;
                    continue;
                }
            }
            else if(s.charAt(i)=='*') count++;
        }
        res+=count;

        return res;
    }
}