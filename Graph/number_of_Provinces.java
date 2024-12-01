/*

DFS is commonly used for problems like Number of Islands and Number of Provinces due to the following reasons:

1. Exploring Connected Components: Both problems involve finding connected components (islands or provinces), and DFS is ideal for exploring all nodes/cells in a component before moving to the next one.
  
2. Grid-based Problems: In problems like Number of Islands, DFS efficiently explores connected land cells, marking them visited as it "dives deep" into each island.

3. Simple Implementation: DFS is often easier to implement for grid or graph traversal. It uses recursion or an explicit stack to explore connected nodes in one go, making it intuitive for marking and counting connected components.

4. Space Efficiency: DFS tends to use less space compared to BFS in grid-based problems because it doesn't require managing a large queue (as BFS does).

5. Better for Depth Exploration: DFS works well in problems where you need to explore all parts of a connected component before moving on, such as fully exploring an island or province.

In summary, DFS is preferred for these problems because it naturally explores connected components, is simple to implement, and handles depth-first exploration efficiently. 

*/

public class number_of_Provinces {

    public void dfs(int[][] isConnected, int city, boolean[] visited) {
        visited[city] = true;
        
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[city][i] == 1 && !visited[i]) {
                dfs(isConnected, i, visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provincesCount = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, i, visited);
                provincesCount++;
            }
        }

        return provincesCount;
    }

    public static void main(String[] args) {
        number_of_Provinces solution = new number_of_Provinces();

        int[][] isConnected1 = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };
        System.out.println("Number of Provinces: " + solution.findCircleNum(isConnected1));

        int[][] isConnected2 = {
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
        };
        System.out.println("Number of Provinces: " + solution.findCircleNum(isConnected2));
    }
}
