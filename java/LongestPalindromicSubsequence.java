public class LongestPalindromicSubsequence {
    public static void main(String[] args){
        System.out.println(longestPalindromeSubseq("axbddba"));
    }
    
    public static int longestPalindromeSubseq(String s) {
        int [][] dp = new int[s.length()][s.length()];
        for(int i = 0; i<s.length(); i++){
            dp[i][i] = 1;
            for(int j = i-1 ; j>=0 ; j--){
                if(s.charAt(i)==s.charAt(j)) 
                    dp[i][j] = 2 + dp[i-1][j+1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j+1]);
            }
        }
        /*for(int i= 0 ;i<s.length() ; i++){
            for(int j= 0 ;j<s.length() ; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }*/
        return dp[s.length()-1][0];
    }
}
