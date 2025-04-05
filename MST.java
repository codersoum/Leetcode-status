class Pair {
    int node;
    int distance;
    
    public Pair(int distance, int node) {
        this.node = node;
        this.distance = distance;
    }
}

class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.offer(new Pair(0, 0));  // distance, node
        boolean[] visited = new boolean[V];
        int sum = 0;

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int e = p.distance;
            int n = p.node;

            if (!visited[n]) {
                visited[n] = true;
                sum += e;

                for (int i = 0; i < adj.get(n).size(); i++) {
                    int[] edge = adj.get(n).get(i);
                    int adjNode = edge[0];
                    int edW = edge[1];

                    if (!visited[adjNode]) {
                        pq.add(new Pair(edW, adjNode));
                    }
                }
            }
        }
        return sum;
    }
}
