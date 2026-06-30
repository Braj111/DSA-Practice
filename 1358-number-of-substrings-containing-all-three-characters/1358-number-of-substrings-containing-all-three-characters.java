class Solution {
    public int numberOfSubstrings(String s) {
        int[] latestPosition = new int[] {-1, -1, -1};
        int answer = 0;
        for (int i = 0; i < s.length(); ++i) {
            char currentChar = s.charAt(i);
            latestPosition[currentChar - 'a'] = i;
            int minPosition = Math.min(latestPosition[0], Math.min(latestPosition[1], latestPosition[2]));
            answer += minPosition + 1;
        }
        return answer;
    }
}