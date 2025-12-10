class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        int n = arr.length;
        int xorVal = 0; 
        for (int i = 0; i < n; i++) {
            xorVal ^= arr[i];
            xorVal ^= (i + 1); 
        }
        int setBitIndex = xorVal & ~(xorVal - 1);
        
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            if ((arr[i] & setBitIndex) != 0) { 
                x ^= arr[i]; 
            }  
            else { 
                y ^= arr[i]; 
            }
            if (((i + 1) & setBitIndex) != 0) { 
                x ^= (i + 1); 
            }
            else { 
                y ^= (i + 1); 
            }
        }
        int missing, repeating;
        
        int xCnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                xCnt++;
            }
        }
        
        if (xCnt == 0) {
            missing = x;
            repeating = y;
        }
        else {
            missing = y;
            repeating = x;
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(repeating);
        result.add(missing);
        return result;
    }
}
