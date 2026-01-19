class Solution {
    public String removeKdig(String s, int k) {
        // code here
        int n = s.length();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            while (!st.isEmpty() && k > 0 && st.peek() > c) {
                st.pop();
                k -= 1;
            }

            if (!st.isEmpty() || c != '0')
                st.push(c);
        }
        while (!st.isEmpty() && k-- > 0)
            st.pop();

        if (st.isEmpty())
            return "0";
        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.append(st.pop());
        }
        return result.reverse().toString();
    }
}