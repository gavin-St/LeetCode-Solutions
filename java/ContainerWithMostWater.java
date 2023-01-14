import java.util.*;

public class ContainerWithMostWater {
    public static void main (String args[]){
        int arr[] = {2,3,4,5,6,7};
        System.out.println(maxArea(arr));
    }
    public static int maxArea(int[] height) {
        int prev[] = new int[10001], ans = 0, max = 0;
        for(int i=0;i<height.length;i++){
            if (height[i] > max){
                for(int j = max + 1; j <= height[i]; j++) 
                    prev[j] = i;
                max = height[i];
            }
            else{
                ans = Math.max((i - prev[height[i]]) * height[i], ans);
            }
        }

        prev = new int[10001]; max = 0;
        for(int i=height.length-1;i>=0;i--){
            if (height[i] > max){
                for(int j = max + 1; j <= height[i]; j++) 
                    prev[j] = i;
                max = height[i];
            }
            else{
                ans = Math.max((prev[height[i]] - i) * height[i], ans);
            }
        }

        return ans;
    }
}
