class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> res = 
            new ArrayList<>(Collections.nCopies(n, 0));
        ArrayList<Integer> len = 
            new ArrayList<>(Collections.nCopies(n + 1, 0));
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                int top = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;
                int windowSize = right - left - 1;
                len.set(windowSize, 
                    Math.max(len.get(windowSize), arr[top]));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek();
            int right = n;
            int windowSize = right - left - 1;
            len.set(windowSize, 
                Math.max(len.get(windowSize), arr[top]));
        }
        for (int i = 1; i <= n; i++) {
            res.set(i - 1, len.get(i));
        }
        for (int i = n - 2; i >= 0; i--) {
            res.set(i, Math.max(res.get(i), res.get(i + 1)));
        }

        return res;
    }
}