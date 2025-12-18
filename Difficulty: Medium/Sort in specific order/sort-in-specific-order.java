import java.util.*;

class Solution {
    public void sortIt(int[] arr) {
        Integer[] boxed = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(boxed, (a, b) -> {
            if (a % 2 == 0 && b % 2 == 0)
                return Integer.compare(a, b);    
            if (a % 2 != 0 && b % 2 != 0)
                return Integer.compare(b, a);     
            return (a % 2 != 0) ? -1 : 1;          
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = boxed[i];
        }
    }
}
