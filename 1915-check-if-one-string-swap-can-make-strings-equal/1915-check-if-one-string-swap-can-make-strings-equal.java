class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
       if(s1==s2) return true;
       char[] arr= new char[4];
       int j=0;
       for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                if(j>2) return false; 
                arr[j]=s1.charAt(i); j++;
                arr[j]=s2.charAt(i); j++;
            }
       }
       if(arr[0]==arr[3] && arr[1]==arr[2]) return true;   
       return false;
    }
}