class Solution {
    List<Integer> makeBeautiful(int[] arr) {
        // code here
        int[] st = new int[arr.length];
        int top = -1;
        for (int i = 0; i < arr.length; i++) {

            if (top == -1) {
                st[++top] = arr[i];
            }
            else {
                boolean top_is_positive = st[top] >= 0;
                boolean curr_is_positive = arr[i] >= 0;
                if (top_is_positive != curr_is_positive) {
                    top--;
                }
                else {
                    st[++top] = arr[i];
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i <= top; i++) {
            result.add(st[i]);
        }

        return result;
    }
}