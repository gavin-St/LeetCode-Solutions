import java.util.*;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(arr));
    }

    public static int trap(int[] height){
        Stack<Integer> s = new Stack<Integer>(), s2 = new Stack<Integer>();
        int ans = 0;
        for(int i = 0; i <height.length; i++){
            int prev = 0;    
            while(!s.isEmpty()){
                    
                    if(s.peek()==height[i]){
                        ans += (height[i] - prev) * (i - s2.peek() - 1);
                        s2.pop(); s2.add(i); 
                        break;
                    }
                    if(s.peek()>height[i]){
                        ans += (height[i] - prev) * (i - s2.peek() - 1);
                        s.add(height[i]); s2.add(i); 
                        break;
                    }
                    else{
                        ans += (s.peek() - prev) * (i - s2.pop() - 1);
                        prev = s.pop(); 
                        //System.out.println(s2.peek());
                    }
                }
                
                if(s.isEmpty()){
                    s.add(height[i]); s2.add(i); 
                }
                //System.out.println(i+": "+ans);
            }

        return ans;
    }
}
