public class LongestPalindromicSubstring {
    public static void main (String[] args){
        System.out.println(longestPalindrome("cadaverabbaravapplaablpp"));
    }
    public static String longestPalindrome(String s) {
        String ans = s.substring(0,1); int max = 0;
        for(int i = 0; i < s.length() - 1; i++){
            int j = 0;
            while(j <= i && i + j <s.length() &&  s.charAt(i+j) == s.charAt(i-j)){
                j++;
            }
            j--;
            if (j > max){
                max = j;
                ans = s.substring(i-j, i+j+1);
            }

            j = 0;
            while(j <= i && i + j + 1 <s.length() &&  s.charAt(i+j + 1) == s.charAt(i-j)){
                j++;
            }
            j--;
            if (j >= max){
                max = j;
                ans = s.substring(i-j, i+j+2);
            }
        }
        return ans;
    }
}
