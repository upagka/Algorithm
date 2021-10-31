package Lesson7;

public interface Graph {

    void addVertex(String label);

    boolean addEdge(String startLabel, String secondLabel, int weight);
    boolean addEdge(String startLabel, String secondLabel);

    int getSize();

    void display();

    /**
     * англ. Depth-first search, DFS
     * @return
     */
    int dfs(String startLabel);

    /**
     * англ. breadth-first search, BFS
     */
    void bfs(String startLabel);

    void bestWay(String startLabel, String finishLabel);
}
