class Pair {
    int node;
    int distance;
    
    public Pair(int distance, int node) {
        this.node = node;
        this.distance = distance;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) 
    {
     int v=points.length;
     PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.offer(new Pair(0, 0));  // distance, node
        boolean[] visited = new boolean[v];
        Map<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<v;i++)
        mp.put(i,Integer.MAX_VALUE);
        int sum = 0;
      while(!pq.isEmpty())
      {
        Pair p=pq.poll();
        int node=p.node;
        int distance=p.distance;
        if(!visited[node])
        {
          visited[node]=true;
          sum+=distance;
          for(int i=0;i<v;i++)
          {
           if(!visited[i])
           {
            int dis=Math.abs(points[i][0]-points[node][0])+Math.abs(points[i][1]-points[node][1]);
             if(dis<mp.get(i))
             mp.put(i,dis);
            pq.offer(new Pair(dis,i));
           }
          }
        }
      }
      return sum;
    }
}
