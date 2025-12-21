class Solution {
    public ArrayList<Integer> countXInRange(int[] arr, int[][] queries) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;

        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int x = query[2];
            int left = lowerBound(arr, x);
            if (left == n || arr[left] != x) {
                result.add(0);
                continue;
            }
            int right = upperBound(arr, x);
            right--;
            left = Math.max(left, l);
            right = Math.min(right, r);
            if (left > right)
                result.add(0);
            else
                result.add(right - left + 1);
        }

        return result;
    }
    private static int lowerBound(int[] arr, int x) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < x) low = mid + 1;
            else high = mid;
        }
        return low;
    }
    private static int upperBound(int[] arr, int x) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= x) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}