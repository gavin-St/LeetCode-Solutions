import java.util.*;
class MinimumTimeToCollectAllApples {
    public static void main (String[]args){
        int n = 7;
        int[][] edges = {{0,1},{0,2},{1, 4},{1,5},{2,3},{2,6}};
        List<Boolean> hasApple = new ArrayList<Boolean>();
        hasApple.add(false); hasApple.add(false); hasApple.add(true);hasApple.add(false);hasApple.add(false);hasApple.add(true);hasApple.add(false);
        System.out.println(minTime(n,edges,hasApple));

    }

    static ArrayList<pair>[] adj;
    static boolean vis[];
    static List<Boolean> ha;
    static int counter;

    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        adj = new ArrayList[n]; vis = new boolean[n];
        ha = hasApple;
        for(int i =0;i< n;i++) 
            adj[i] = new ArrayList<pair>();
        
        for(int i =0; i<edges.length;i++){
            adj[edges[i][0]].add(new pair(edges[i][1], false));
            adj[edges[i][1]].add(new pair(edges[i][0], false));
        }
        
        vis[0] = true;
        dfs(0);
        

        /*for(int i =0;i<end.length;i++){
            for(int j =0;j<3;j++){
                System.out.print(end[i][j]+" ");
            }
            System.out.println();
        }*/

        Arrays.fill(vis, false);
        counter = 1; 
        vis[0] = true;
        dfs2(0);

        return 2*(counter-1);

    }

    public static boolean dfs(int n){
        //System.out.println("n: "+n);
        if(ha.get(n)){ 
            for(int i = 0; i<adj[n].size();i++){
                int cur = adj[n].get(i).a;
                if(!vis[cur]){
                    //System.out.println(i);
                    vis[cur] = true;
                    adj[n].remove(i);
                    adj[n].add(i,new pair(cur,dfs(cur)));
                }
            }
            return true;
        }
        else{
            boolean f = false;
            for(int i = 0; i<adj[n].size();i++){
                int cur = adj[n].get(i).a;
                if(!vis[cur]){
                    vis[cur] = true;
                    boolean temp = (dfs(cur));
                    adj[n].remove(i);
                    adj[n].add(i,new pair(cur,temp));
                    f = f || temp;
                }
            }
            return f;
        }
    }

    static void dfs2(int n){
        //System.out.println(n);
        for(int i = 0; i<adj[n].size();i++){
            int cur = adj[n].get(i).a;
            if(!vis[cur]&& adj[n].get(i).b){
                vis[cur] = true;
                counter++;
                dfs2(cur);
            }
        }
    }

    public static class pair{
        int a; boolean b;
        pair(int a, boolean b){
            this.a = a; this.b = b;
        }
    }
}