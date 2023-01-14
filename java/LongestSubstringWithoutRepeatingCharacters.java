import java.util.*;
class LongestSubstringWithoutRepeatingCharacters {
    public static void main (String args[]){
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(lengthOfLongestSubstring("s3487687tyuiuidcfbnhfdjuyerdsk"));
    }
    public static int lengthOfLongestSubstring(String s) {
        int ans = 0, max = 0;
        char[] c = s.toCharArray();
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for(int i =0; i<c.length; i++){
            if(hm.getOrDefault(c[i],-1) + ans >= i)
                ans = i - hm.get(c[i]);
            else
                ans++; 
            hm.put(c[i], i);
            max = Math.max(max, ans);
        }
        return max;
    }
}