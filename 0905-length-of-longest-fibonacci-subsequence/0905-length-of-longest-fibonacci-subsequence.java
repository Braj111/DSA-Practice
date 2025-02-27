class Solution {
    // Method-1 Considering all initial pairs - O(n^2 * log(max-num))
    public int lenLongestFibSubseq(int[] arr) {
        Set<Integer> s = new HashSet<>();
        for (int num : arr) {
            s.add(num);
        }

        int n = arr.length, ans = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j < n; j++) {
                int a = arr[i];
                int b = arr[j];

                int curr = 2;
                while (s.contains(a+b)) {
                    int sum = a + b;
                    a = b;
                    b = sum;
                    curr++;
                }
                if (curr > 2)
                    ans = Math.max(ans, curr);
            }

        }
        return ans;
    }
}