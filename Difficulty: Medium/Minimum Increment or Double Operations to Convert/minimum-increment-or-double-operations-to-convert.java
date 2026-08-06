class Solution {
    public int countMinOperations(int arr[]) {
        // code here
        int incs = 0;  
        int maxLen = 0;  
        
        for (int val : arr) {
            int len = 0;

            while (val > 0) {
                if ((val & 1)!= 0) {
                    incs++;
                }
                len++;
                val >>= 1; 
            }

            maxLen = Math.max(maxLen, len);
        }
        int dbls = Math.max(0, maxLen - 1);

        return incs + dbls;
    }
}