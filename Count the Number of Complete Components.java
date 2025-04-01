class Solution {
    ArrayList<ArrayList<Integer>>adj;
    public int countCompleteComponents(int n, int[][] edges) 
    {
       int components=0;
      adj= new ArrayList<>();
      for(int i=0;i<n;i++)
      {
        adj.add(new ArrayList<>());
      }
      for(int [] edge:edges)
      {
        adj.get(edge[0]).add(edge[1]);
        adj.get(edge[1]).add(edge[0]);
      }
      int [] vis=new int[n];
      for(int i=0;i<n;i++)
      {
        if(vis[i]==0)
        {
          int [] component=new int[2];
          dfs(i,adj,vis,component);
          if(component[0]*(component[0]-1)==component[1])
          components++;
        }
      }
      return components;  
    }
     public static void dfs(int node,ArrayList<ArrayList<Integer>> adj,int []vis,int [] component)
    {
       vis[node]=1;
       component[0]++;
       component[1]+=adj.get(node).size();
       for(int v:adj.get(node))
       {
        if(vis[v]==0)
        dfs(v,adj,vis,component);
       }
    }
}
