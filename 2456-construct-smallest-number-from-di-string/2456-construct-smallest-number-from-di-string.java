class Solution {
    // Array to keep track of visited digits
    private boolean[] visited = new boolean[10];
    // StringBuilder to construct the sequence incrementally
    private StringBuilder sequence = new StringBuilder();
    // String to store the given pattern
    private String pattern;
    // String to store the final answer sequence
    private String answer;

    public String smallestNumber(String pattern) {
        this.pattern = pattern;
        dfs(0);
        return answer;
    }
    private void dfs(int position) {
        if (answer != null) {
            return;
        }
        if (position == pattern.length() + 1) {
            answer = sequence.toString();
            return; 
        }
        for (int i = 1; i < 10; ++i) {
            if (!visited[i]) {
                if (position > 0 && pattern.charAt(position - 1) == 'I' && sequence.charAt(position - 1) - '0' >= i) {
                    continue; 
                }
                if (position > 0 && pattern.charAt(position - 1) == 'D' && sequence.charAt(position - 1) - '0' <= i) {
                    continue; 
                }
                visited[i] = true;
                sequence.append(i);
                dfs(position + 1);
                sequence.deleteCharAt(sequence.length() - 1);
                visited[i] = false;
            }
        }
    }
}
