class Solution {
    
    static int countBits(int n) {
        int cnt = 0;
        while (n > 0) {
            n = n & (n - 1);
            cnt++;
        }
        return cnt;
    }

    static ArrayList<Integer> sortBySetBitCount(int[] arr) {
        int n = arr.length;
        
        ArrayList<ArrayList<Integer>> count = new ArrayList<>();

        for (int i = 0; i < 32; i++) {
            count.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int setBit = countBits(arr[i]);
            count.get(setBit).add(arr[i]);
        }

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 31; i >= 0; i--) {
            for (int num : count.get(i)) {
                res.add(num);
            }
        }

        return res;
    }
}