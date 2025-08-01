class Solution {
    boolean isVovel(char ch){
        return ch =='a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    public int countBalanced(String[] arr) {
        int n= arr.length;
        int ans=0;
        int pre=0;
        
        Map<Integer,Integer> map= new HashMap<>();
        map.put(0,1);
        for(int i=0; i<n; i++){
            int net=0;
            for(char ch: arr[i].toCharArray()){
                if(isVovel(ch)) net++;
                else net--;
            }
            pre+=net;
            ans+=map.getOrDefault(pre,0);
            map.put(pre, map.getOrDefault(pre,0)+1);
            
        }
        return ans;
    }
}