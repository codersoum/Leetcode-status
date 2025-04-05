class Solution{
    static long ans;
    public long largesSumCycle(int N, int Edge[])
    {
      int [] vis=new int[N];
      int [] path=new int[N];
      ans=-1;
      for(int i=0;i<N;i++)
      {
        if(vis[i]==0)
        dfs(i,vis,path,Edge);
      }
      return ans;
    }
    public static void dfs(int i,int [] vis,int [] path,int [] Edge)
    {
      vis[i]=1;
      path[i]=1;
      if(Edge[i]!=-1)
      {
       int adj=Edge[i];
       if(vis[adj]==0)
       dfs(adj,vis,path,Edge);
       else if(path[adj]==1)
       {
         long sum=adj;
         int cur=Edge[adj];
         while(cur!=adj)
         {
          sum+=cur;
          cur=Edge[cur];
         }
         ans=Math.max(ans,sum);
       }
      }
      path[i]=0;
    }
}
