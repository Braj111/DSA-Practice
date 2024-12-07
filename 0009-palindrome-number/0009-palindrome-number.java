class Solution {
    public boolean isPalindrome(int x) {
       String num = String.valueOf(x);
       int len = num.length();
       boolean flag = false;
       for(int i=0; i<=len/2; i++){
           if(num.charAt(i) == num.charAt(len-1-i)){
               flag = true;
           }else{
               flag = false;
               break;
           }
       }
       if(flag)
            return true;
        else
            return false;
    }
}