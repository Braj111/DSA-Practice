class Solution {
    static int[] previousGreater(int[] arr) {
        int n = arr.length;
        int[] prev = new int[n];
        Arrays.fill(prev, -1); 
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) prev[i] = st.peek();
            st.push(i);
        }
        return prev;
    }
    static int[] nextGreater(int[] arr) {
        int n = arr.length;
        int[] next = new int[n];
        Arrays.fill(next, n); 
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) next[i] = st.peek();
            st.push(i);
        }
        return next;
    }

    static int maxPeople(int[] arr) {
        int n = arr.length;
        int[] prev = previousGreater(arr);
        int[] next = nextGreater(arr);

        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            int leftBound = (prev[i] == -1 ? 0 : prev[i] + 1);
            int rightBound = (next[i] == n ? n - 1 : next[i] - 1);
            int count = rightBound - leftBound + 1;

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}
