vector<vector<int>> adj;
int timer=0;

void dfs(int u, vector<int>& disc, vector<int>& low, vector<int>& parent, vector<pair<int, int>>& bridge) {
    disc[u] = low[u] = timer++;
    for (int v : adj[u]) {
        if (disc[v] == -1) {
            parent[v] = u;
            dfs(v, disc, low, parent, bridge);
            low[u] = min(low[u], low[v]);

            if (low[v] > disc[u]) {
                bridge.push_back({u, v});
            }
        }
        else if (v != parent[u]) {
            low[u] = min(low[u], disc[v]);
        }
    }
}

vector<vector<int>> findBridges(vector<vector<int>> &edge, int v, int e) {
    adj.clear();
    adj.resize(v);

    for (int i = 0; i < e; i++) {
        int u = edge[i][0], v2 = edge[i][1];
        adj[u].push_back(v2);
        adj[v2].push_back(u);
    }

    vector<int> disc(v, -1), low(v, -1), parent(v, -1);
    vector<pair<int, int>> bridge;
    timer=0;
    for (int i = 0; i < v; i++) {
        if (disc[i] == -1) {
            dfs(i, disc, low, parent, bridge);
        }
    }

    vector<vector<int>> result;
    for (auto& p : bridge) {
        result.push_back({p.first, p.second});
    }
    return result;
}
