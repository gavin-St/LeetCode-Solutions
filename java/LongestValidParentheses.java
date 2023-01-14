import java.util.*;
class LongestValidParentheses {
    public static void main (String args[]){
        System.out.println(longestValidParentheses("))((((((())(()))("));
    }
    public static int longestValidParentheses(String s) {
                        int ans = 0, cur = 0;
                        Stack<Integer> st = new Stack<Integer>(), st2 = new Stack<Integer>();
                        for(int i= 0; i<s.length(); i++){
                            if(s.charAt(i) == '('){
                                st.add(i); st2.add(cur);
                                cur = 0;
                            }
                            else{
                                if(!st.isEmpty()){
                                    cur = i - st.pop() + st2.pop() + 1;
                                    ans = Math.max(ans, cur);
                                }
                                else{
                                    cur = 0;
                                }
                            }
                        }

                        return ans;
    }
}