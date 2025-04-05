class Solution {
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        int V = adj.size();
        int[] dis = new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;

        PriorityQueue<iPair> pq = new PriorityQueue<>((a, b) -> a.second - b.second);
        pq.offer(new iPair(src, 0));

        while (!pq.isEmpty()) {
            iPair p = pq.poll();
            int u = p.first;

            for (iPair ip : adj.get(u)) {
                int v = ip.first;
                int weight = ip.second;

                if (dis[u] + weight < dis[v]) {
                    dis[v] = dis[u] + weight;
                    pq.offer(new iPair(v, dis[v]));
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int d : dis) {
            result.add(d);
        }
        return result;
    }
}
