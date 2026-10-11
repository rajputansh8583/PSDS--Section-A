#include <iostream>
#include <vector>
#include <queue>
#include <climits>
using namespace std;

struct Edge {
    int to;
    int weight;
};

struct State {
    int cost;
    int node;
    int edges;

    bool operator>(const State& other) const {
        return cost > other.cost;
    }
};

int main() {
    int N, M, K;

    cout << "Enter number of nodes (N): ";
    cin >> N;

    cout << "Enter number of edges (M): ";
    cin >> M;

    cout << "Enter maximum number of edges allowed (K): ";
    cin >> K;

    vector<vector<Edge>> graph(N + 1);

    cout << "Enter " << M << " edges (u v weight):" << endl;

    for (int i = 0; i < M; i++) {
        int u, v, w;
        cin >> u >> v >> w;

        graph[u].push_back({v, w});
        graph[v].push_back({u, w});
    }

    const int INF = INT_MAX;

    // dist[node][edges] = minimum cost to reach node
    // using exactly 'edges' edges
    vector<vector<int>> dist(N + 1, vector<int>(K + 1, INF));

    priority_queue<State, vector<State>, greater<State>> pq;

    dist[1][0] = 0;
    pq.push({0, 1, 0});

    while (!pq.empty()) {
        State current = pq.top();
        pq.pop();

        int cost = current.cost;
        int node = current.node;
        int edges = current.edges;

        if (cost != dist[node][edges])
            continue;

        if (node == N) {
            cout << "Minimum path weight = " << cost << endl;
            return 0;
        }

        if (edges == K)
            continue;

        for (Edge e : graph[node]) {
            int newNode = e.to;
            int newCost = cost + e.weight;
            int newEdges = edges + 1;

            if (newCost < dist[newNode][newEdges]) {
                dist[newNode][newEdges] = newCost;
                pq.push({newCost, newNode, newEdges});
            }
        }
    }

    cout << "Minimum path weight = -1" << endl;

    return 0;
}