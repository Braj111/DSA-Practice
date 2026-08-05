class Solution {
     static int mergeSort(long[] prefix, int left, int right, int l, int r)
    {

        if (right - left <= 1)
            return 0;

        int mid = left + (right - left) / 2;
        int cnt = mergeSort(prefix, left, mid, l, r)
                  + mergeSort(prefix, mid, right, l, r);

        int low = mid;
        int high = mid;
        for (int i = left; i < mid; i++) {
            while (low < right
                   && prefix[low] - prefix[i] < l)
                low++;
            while (high < right
                   && prefix[high] - prefix[i] <= r)
                high++;
            cnt += (high - low);
        }
        ArrayList<Long> temp = new ArrayList<>();

        int i = left, j = mid;

        while (i < mid && j < right) {
            if (prefix[i] <= prefix[j])
                temp.add(prefix[i++]);
            else
                temp.add(prefix[j++]);
        }
        while (i < mid)
            temp.add(prefix[i++]);
        while (j < right)
            temp.add(prefix[j++]);
        for (int k = 0; k < temp.size(); k++)
            prefix[left + k] = temp.get(k);

        return cnt;
    }
    static int countSubarray(int[] arr, int l, int r)
    {

        int n = arr.length;
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++)
            prefix[i + 1] = prefix[i] + arr[i];
        return mergeSort(prefix, 0, n + 1, l, r);
    }

}