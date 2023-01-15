class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<Integer>(), s2 = new Stack<Integer>();
        int n = heights.length, ans = 0, left[] = new int[n];
        for(int i=0;i<heights.length;i++){
            while(!s.isEmpty()){
                if(s.peek()<heights[i]){
                    left[i] = s2.peek();
                    s.add(heights[i]); s2.add(i); 
                    break;
                }
                else{
                    ans = Math.max(ans, s.pop()*(i-left[s2.pop()]-1));
                }
            }
            if(s.isEmpty()){
                s.add(heights[i]); s2.add(i); left[i] = -1;
            }
        }
        while(!s.isEmpty()){
            ans = Math.max(ans, s.pop()*(n-left[s2.pop()]-1));
        }
        return ans;
    }
}
