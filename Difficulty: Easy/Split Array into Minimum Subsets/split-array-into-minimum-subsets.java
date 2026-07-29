class Solution {
    int minSubsets(int arr[]) {
        // code here
        Set<Integer> s = new HashSet<>();
        for(int num : arr){
            s.add(num);
        }
        
        int count = 0;
        for(int x : arr){
            if(!s.contains(x - 1)){
                count++;
            }
        }
        return count;
    }
}