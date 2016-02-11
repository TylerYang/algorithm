public class WeightedQuickUnionUF{ 
    int count;
    int[] sz, id;
    public WeightedQuickUnionUF(int N) {
        count = N;
        sz = new int[N];
        id = new int[N];
        for(int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }
    private int count() {
        return count;
    }
    private boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    private int find(int p) {
        while(p != id[p]) p = id[p];
        return p;
    }
    private void union(int p, int q){ 
        int pId = id[p], qId = id[q];
        if(pId == qId) return;
        if(sz[pId] < sz[qId]) {
            id[pId] = qId;
            sz[qId] += sz[pId];
        } else {
            id[qId] = pId;
            sz[pId] += sz[qId];
        }
        count--;
    }
}
