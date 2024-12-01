/*
The Breadth-First Search (BFS) is used in this problem (rotting oranges) instead of Depth-First Search (DFS) for the following key reasons:

1. Level-wise propagation: BFS ensures that all oranges rot level by level, mimicking the spread of rot from rotten oranges to fresh ones in a real-world scenario. Each "minute" of rotting corresponds to a level of BFS, ensuring we measure the time it takes for the rot to reach all fresh oranges.

2. Optimal time measurement: BFS naturally processes each level of rot before moving to the next. This is important to ensure that we account for the minimum number of minutes required for all reachable fresh oranges to rot.

3. Avoids deep recursion: In DFS, you might encounter issues with stack overflow for large grids due to deep recursion. BFS avoids this issue since it processes nodes iteratively using a queue.

4. Guaranteeing minimum steps: BFS explores all immediate neighbors of a rotten orange first before moving further. This guarantees that once all possible adjacent fresh oranges are processed, no further time steps are skipped.

In summary, BFS is well-suited to this problem because it handles the spread of rot level by level, ensuring both correctness and efficiency in calculating the minimum time. 
 
*/


import java.util.*;

public class rotting_Oranges {

    // Directions for 4-connected neighbors (up, down, left, right)
    private static final int[] DIRS = {-1, 0, 1, 0, -1, 0};

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

    
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0; 

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});  // Rotten orange
                } else if (grid[i][j] == 1) {
                    freshCount++;  // Count fresh oranges
                }
            }
        }


        if (freshCount == 0) {
            return 0;
        }

        int minutes = 0;

        // BFS to rot the adjacent fresh oranges
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];

                // Check all 4 adjacent cells
                for (int j = 0; j < 4; j++) {
                    int newX = x + DIRS[j];
                    int newY = y + DIRS[j + 1];

                    // Check if the new cell is within bounds and is a fresh orange
                    if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;  // Make it rotten
                        freshCount--;  // Decrease the fresh orange count
                        queue.offer(new int[]{newX, newY});  // Add to the queue for the next level of BFS
                        rotted = true;
                    }
                }
            }

            // If any fresh orange rotted, increase the minutes
            if (rotted) {
                minutes++;
            }
        }

        // If there are still fresh oranges left, return -1 (impossible to rot all)
        return freshCount == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        rotting_Oranges solution = new rotting_Oranges();

        // Test case 1
        int[][] grid1 = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        System.out.println(solution.orangesRotting(grid1));  // Output: 4

        // Test case 2
        int[][] grid2 = {
            {2, 1, 1},
            {0, 1, 1},
            {1, 0, 1}
        };
        System.out.println(solution.orangesRotting(grid2));  // Output: -1

        // Test case 3
        int[][] grid3 = {
            {0, 2}
        };
        System.out.println(solution.orangesRotting(grid3));  // Output: 0
    }
}
