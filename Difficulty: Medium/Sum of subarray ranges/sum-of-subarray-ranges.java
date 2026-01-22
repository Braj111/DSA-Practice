import java.util.*;

class Solution {
    public int subarrayRanges(int[] arr) {
        int n = arr.length;
        long maxSum = sumSubarrayMax(arr, n);
        long minSum = sumSubarrayMin(arr, n);
        return (int)(maxSum - minSum);
    }

    private long sumSubarrayMax(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        long res = 0;

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || arr[stack.peek()] < arr[i])) {
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;

                long count = (long)(mid - left) * (right - mid);
                res += count * arr[mid];
            }
            stack.push(i);
        }
        return res;
    }

    private long sumSubarrayMin(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        long res = 0;

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || arr[stack.peek()] > arr[i])) {
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;

                long count = (long)(mid - left) * (right - mid);
                res += count * arr[mid];
            }
            stack.push(i);
        }
        return res;
    }
}
