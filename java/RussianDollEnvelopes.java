import java.util.Arrays;

public class RussianDollEnvelopes {
    public static void main(String[] args){
        int[][] arr = {{1,6},{3,4}};
        System.out.println(maxEnvelopes(arr));
    }
    
    public static int maxEnvelopes(int[][] envelopes) {
        pair[] arr = new pair[envelopes.length];
        for(int i =0; i < envelopes.length; i++){
            arr[i] = new pair(envelopes[i][0], envelopes[i][1]);
        }
        Arrays.sort(arr);
        int[] ws = new int[envelopes.length];
        for(int i =0; i < envelopes.length; i++){
            ws[i] = arr[i].w;
        }
        int dp[] = new int[envelopes.length+1], max = 0;
        for(int i =0; i<envelopes.length; i++){
            if(max == 0 || ws[i] > dp[max]){
                dp[++max] = ws[i];
            }
            else{
                int p = Arrays.binarySearch(dp, 0, max, ws[i]);
                if(p < 0) 
                    p = -p - 1;
                dp[p] = ws[i];
            }
        }
        return max;
    }

    public static class pair implements Comparable<pair>{
        int l, w;
        public pair(int a, int b){
            l = a; w = b;
        }
        public int compareTo(pair p){
            if (this.l == p.l) return p.w - this.w;
            return this.l - p.l;
        }
    }

    public static int binSearch(int[] arr, int v) {
        int left = 0, right = arr.length-1, m = (left + right)/2;
        while (left < right){
            System.out.println(left + " " + right + " " + m + " val: " + arr[m]);
            if (arr[m] == v) 
                break;
            if (m == right && arr[m] > v)
                break;
            if (arr[m] > v){
                right = m;
                m = (left + right) / 2;
            }
            else{
                left = m;
                m = (left + right + 1) / 2;
            }
        }
        if (arr[m] < v) return -1 * arr.length -1;
        return arr[m] == v? m : -1 * m - 1;
    }
}
