class Solution {
    private List<String> happyStrings= new ArrayList<>();
    public String getHappyString(int n, int k) {
        generatorUtil("",n);
        return happyStrings.size()>=k ? happyStrings.get(k-1) : "";
    }
    //DFS recursive approach
    public void generatorUtil(String str, int n) {
        if(str.length()==n){
            happyStrings.add(str); return;
        }
        for(char s: "abc".toCharArray()){
            if(str.length()>0 && s==str.charAt(str.length()-1)) continue;
            generatorUtil(str+s, n);
        }
    }
}