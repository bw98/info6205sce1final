import java.util.*;
class LargestTree{
    static void addEdge(LinkedList<Integer> adj[], int u, int v)
    {
        //TO-DO:
        // if (u == v) return;

        adj[u].add(v);
    }

    static int treeSize = 0;

    static int DFS(int u, LinkedList<Integer> adj[], Vector<Boolean> visited)
    {
        visited.set(u, true);
        int size = 1;

        // Iterate through all the nodes and perform DFS if the node is not yet visited
        //TO-DO:
        treeSize = 1;
        dfs(u, adj, visited);
        return treeSize;
    }

    static private void dfs(int u, LinkedList<Integer> adj[], Vector<Boolean> visited) {
        for (int j : adj[u]) {
            if (visited.get(j) == false) {
                treeSize += 1;
                visited.set(j, true);

                dfs(j, adj, visited);
            }
        }
    }

    public int largestTree(LinkedList<Integer> adj[], int V)
    {
        //TO-DO:
        if (cntEdge(adj) == 0) {
            return 0;
        }

        Vector<Boolean> visited = new Vector<>(V);
        for (int i = 0; i < V; ++i) {
            visited.add(false);
        }

        int maxTreeSize = 0;
        for (int i = 0; i < V; ++i) {
            int ts = DFS(i, adj, visited);
            if (maxTreeSize < ts) {
                maxTreeSize = ts;
            }
        }

        return maxTreeSize;
    }

    private int cntEdge(LinkedList<Integer> adj[]) {
        int cntEdge = 0;
        for (int i = 0; i < adj.length; i++) {
            for (Integer x : adj[i]) {
                cntEdge += 1;
            }
        }

        return cntEdge;
    }
}