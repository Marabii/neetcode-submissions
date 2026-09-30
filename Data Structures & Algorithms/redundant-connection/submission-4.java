class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if (uf.union(edge[0], edge[1])) {
                return edge;
            }
        }

        // unreachable!()
        return null;
    }

    private static class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int n) {
            this.parent = new int[n + 1];
            this.rank = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                this.parent[i] = i;
            }
        }

        public boolean union(int i, int j) {
            int iR = find(i);
            int jR = find(j);

            if (iR == jR) {
                return true;
            }

            if (this.rank[iR] > this.rank[jR]) {
                this.parent[jR] = iR;
            } else if (this.rank[iR] < this.rank[jR]) {
                this.parent[iR] = jR;
            } else {
                this.parent[iR] = jR;
                this.rank[jR]++;
            }

            return false;
        }

        public int find(int i) {
            while (this.parent[i] != this.parent[this.parent[i]]) {
                this.parent[i] = this.parent[this.parent[i]]; // path compression
                i = this.parent[i];
            }

            return this.parent[i];
        }
    }
}
