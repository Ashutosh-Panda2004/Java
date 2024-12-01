/*

DFS is commonly used for problems like Number of Islands and Number of Provinces due to the following reasons:

1. Exploring Connected Components: Both problems involve finding connected components (islands or provinces), and DFS is ideal for exploring all nodes/cells in a component before moving to the next one.
  
2. Grid-based Problems: In problems like Number of Islands, DFS efficiently explores connected land cells, marking them visited as it "dives deep" into each island.

3. Simple Implementation: DFS is often easier to implement for grid or graph traversal. It uses recursion or an explicit stack to explore connected nodes in one go, making it intuitive for marking and counting connected components.

4. Space Efficiency: DFS tends to use less space compared to BFS in grid-based problems because it doesn't require managing a large queue (as BFS does).

5. Better for Depth Exploration: DFS works well in problems where you need to explore all parts of a connected component before moving on, such as fully exploring an island or province.

In summary, DFS is preferred for these problems because it naturally explores connected components, is simple to implement, and handles depth-first exploration efficiently. 

*/

import java.util.*;

public class Number_of_Islands {

    static void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        int rows = grid.length;
        int cols = grid[0].length;

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i, j});

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int x = current[0];
            int y = current[1];

            // Skip if out of bounds or water ('0') or already visited
            if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] == '0' || visited[x][y]) {
                continue;
            }

            visited[x][y] = true;  

            stack.push(new int[]{x + 1, y});  // Down
            stack.push(new int[]{x - 1, y});  // Up
            stack.push(new int[]{x, y + 1});  // Right
            stack.push(new int[]{x, y - 1});  // Left
        }
    }

    // Function to count the number of islands
    static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];  
        int islandCount = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    islandCount++;  
                }
            }
        }

        return islandCount;  
    }

    public static void main(String[] args) {

        char[][] grid1 = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        System.out.println("Number of Islands: " + numIslands(grid1));  

        char[][] grid2 = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        System.out.println("Number of Islands: " + numIslands(grid2));  
    }
}
