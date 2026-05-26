class Solution {
    int minToggle(int[] arr) {
        // code here
        int oneCount = 0;
        int toggle = 0;

        for (int x : arr) {
            if (x == 1) {
                oneCount++;
            }
            else {
                toggle = Math.min(toggle + 1, oneCount);
            }
        }

        return toggle;
    }
}