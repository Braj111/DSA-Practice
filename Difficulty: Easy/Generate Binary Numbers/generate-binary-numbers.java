class Solution {
    public ArrayList<String> generateBinary(int n) {
        // code here
        ArrayList<String> res = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.add("1");
        while (n-- > 0) {
            
            String s1 = q.poll();
            res.add(s1);

            String s2 = s1;
            
            if(q.size() < n){
                q.add(s1 + "0");
                q.add(s2 + "1");
            }
        }
        return res;
    }
}
