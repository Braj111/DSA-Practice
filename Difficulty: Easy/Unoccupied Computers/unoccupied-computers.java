class Solution {
    public int solve(int n, String s) {
        // code here
        int[] state = new int[26];

        int occupied = 0;
        int rejected = 0;

        for (char c : s.toCharArray()) {
            int idx = c - 'A';
            if (state[idx] == 0) {
                state[idx] = 1;
                if (occupied < n) {
                    occupied++;
                    state[idx] = 2;
                }
                else {
                    rejected++;
                }
            }
            else {
                if (state[idx] == 2) {
                    occupied--;
                }
                state[idx] = 0;
            }
        }

        return rejected;
    }
}
