import java.util.*;

class TwoSum {
    public static void main (String args[]){
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(twoSum(arr, 15)[0] + " " + twoSum(arr, 15)[1]);
    }
    
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        int ans[] = {1,2};
        for(int i = 0; i < nums.length; i++){
            if(hm.containsKey(target - nums[i])){
                ans[1] = i;
                ans[0] = hm.get(target - nums[i]);
                break;
            }
            hm.put(nums[i],i);
        }

        return ans;
    }
}