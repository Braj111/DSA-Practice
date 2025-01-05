class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int[] net = new int[n];

        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2] == 1 ? 1 : -1; 

            net[start] += direction;
            if (end + 1 < n) {
                net[end + 1] -= direction;
            }
        }
        for (int i = 1; i < n; i++) {
            net[i] += net[i - 1];
        }

        for (int i = 0; i < n; i++) {
            int shift = net[i] % 26;
            if (shift < 0) shift += 26;
            arr[i] = (char) (((arr[i] - 'a' + shift) % 26) + 'a');
        }
        return new String(arr);
    }
}