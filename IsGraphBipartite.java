class Solution {
    public boolean isBipartite(int[][] graph) 
    { 
        int [] vis=new int[graph.length];
        Arrays.fill(vis,-1);
        for(int i=0;i<graph.length;i++)
        {
          if(vis[i]==-1)
          {
            if(!helper(graph,i,vis,0))
            return false;
          }
        }
        return true;
    }
    public boolean helper(int [][] graph,int i,int [] vis,int set)
    {
      Queue<Integer>q=new LinkedList<>();
      q.offer(i);
      vis[i]=set;
      while(!q.isEmpty())
      {
        int u=q.poll();
        for(int x:graph[u])
        {
          if(vis[x]==-1)
          {
            q.offer(x);
            vis[x]=1-vis[u];
          }
          else if(vis[x]==vis[u])
          return false;
        }
      }
      return true;
    }
}
