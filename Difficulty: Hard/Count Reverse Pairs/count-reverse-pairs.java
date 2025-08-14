class Solution {
    static int merging(int[] arr, int low, int mid, int high) {
                                
        int count = 0, j = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (j <= high && arr[i] > 2L * arr[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }
        List<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left++]);
            } else {
                temp.add(arr[right++]);
            }
        }

        while (left <= mid) {
            temp.add(arr[left++]);
        }

        while (right <= high) {
            temp.add(arr[right++]);
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }

        return count;
    }
    static int mergeSort(int[] arr, int low, int high) {
        
        if (low >= high) {
            return 0;
        }

        int mid = low + (high - low) / 2;
        int count = mergeSort(arr, low, mid) + 
                    mergeSort(arr, mid + 1, high) +
                    merging(arr, low, mid, high);

        return count;
    }
    static int countRevPairs(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }
}