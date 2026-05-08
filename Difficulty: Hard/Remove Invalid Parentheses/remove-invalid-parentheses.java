class Solution {

    public static boolean isValid(String s)
    {
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(')
                count++;
            else if (c == ')') {
                count--;

                if (count < 0)
                    return false;
            }
        }

        return count == 0;
    }

    public static List<String> validParenthesis(String s)
    {
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        List<String> result = new ArrayList<>();

        q.add(s);
        visited.add(s);

        boolean found = false;

        while (!q.isEmpty()) {

            String curr = q.poll();

            if (isValid(curr)) {
                result.add(curr);
                found = true;
            }

            if (found)
                continue;

            for (int i = 0; i < curr.length(); i++) {

                if (curr.charAt(i) != '('
                    && curr.charAt(i) != ')')
                    continue;

                String next = curr.substring(0, i)
                              + curr.substring(i + 1);

                if (!visited.contains(next)) {
                    visited.add(next);
                    q.add(next);
                }
            }
        }

        Collections.sort(result);

        return result;
    }
}