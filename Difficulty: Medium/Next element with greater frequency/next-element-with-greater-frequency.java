class Solution {
    public ArrayList<Integer> findGreater(int[] arr) {
        // code here
        int n = arr.length;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && freq.get(arr[i]) >
                                freq.get(arr[s.peek()])) {
                res[s.pop()] = arr[i];
            }
            s.push(i);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int x : res) {
            result.add(x);
        }
        return result;
    }
}