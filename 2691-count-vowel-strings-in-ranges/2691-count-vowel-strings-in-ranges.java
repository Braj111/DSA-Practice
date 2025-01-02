class Solution {
    private List<Integer> arr= new ArrayList<>();
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        for(int i=0; i<words.length; i++){
            char a=words[i].charAt(0), b=words[i].charAt(words[i].length()-1);
            if(vowels.contains(a) && vowels.contains(b)) arr.add(i);
        }
        
        int[] ans = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            int l=queries[i][0], r=queries[i][1];
            int temp=0;
            ans[i]=search(r + 1) - search(l);;
        }
        return ans;
    }
    private int search(int x) {
        int l = 0, r = arr.size();
        while (l < r) {
            int mid = (l + r) >> 1;
            if (arr.get(mid) >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

}