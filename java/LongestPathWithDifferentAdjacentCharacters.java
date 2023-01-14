import java.util.*;
public class LongestPathWithDifferentAdjacentCharacters {
    public static void main (String[]args){
        int[] parent = {-1,0,0,0};
        String s = "aabc";
        System.out.println(longestPath(parent,s));
    }

    static ArrayList<Integer>[] adj;
    static int dis[];

    public static int longestPath(int[] parent, String s) {
        int n = parent.length;
        adj = new ArrayList[n];
        dis = new int[n];
        adj[0] = new ArrayList<Integer>();

        for(int i=1;i<n;i++){
            adj[i] = new ArrayList<Integer>();
            if(s.charAt(i)!=s.charAt(parent[i])){
                adj[i].add(parent[i]);
                adj[parent[i]].add(i);
            }
        }

        int max = 0;
        for(int i =0;i<n;i++){
            if(dis[i]==0){
                dis[i] = 1;
                //System.out.println("Try: "+i);
                max = Math.max(max, diameter(i));
                //System.out.println(max);
            }
        }

        return max;
    }
    static int diameter(int n){
        int last = n, dis2[] = new int[dis.length];
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(n);
        while(!q.isEmpty()){
            int cur =q.poll();
            for(int i : adj[cur]){
                if(dis[i]==0){
                    dis[i] = dis[cur] + 1;
                    q.add(i);
                    last = i;
                }
            }
        }
        
        q.add(last); dis2[last] = 1;
        last = 1;
        while(!q.isEmpty()){
            int cur =q.poll();
            //System.out.println(cur);
            for(int i : adj[cur]){
                if(dis2[i]==0){
                    //System.out.println(i);
                    dis2[i] = dis2[cur] + 1;
                    q.add(i);
                    last = dis2[i];
                }
            }
        }
        //System.out.println(last);
        return last;
    }
}
