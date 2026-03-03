class Solution {
    public int totalElements(int[] arr) {
        // code here
        Map<Integer, Integer> mp = new HashMap<>();
        int i = 0, j = 0, n = arr.length;
        int size = 0;
        while (j < n) {
            mp.put(arr[j], mp.getOrDefault(arr[j], 0) + 1);
            while (mp.size() > 2) {
                mp.put(arr[i], mp.get(arr[i]) - 1);
                if (mp.get(arr[i]) == 0)
                    mp.remove(arr[i]);
                i++; 
            }

            size = Math.max(size, j - i + 1);
            j++; 
        }

        return size;
    }
}