package UnionFind;

public interface UF {
    void union(int p, int q);
    boolean connected(int p, int q);
    int find(int p);
    int count();
}
