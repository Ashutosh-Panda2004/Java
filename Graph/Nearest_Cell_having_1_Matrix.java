import java.util.*;

public class Nearest_Cell_having_1_Matrix {
    
    // Function to update matrix with nearest distance of 1
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        // Directions array for up, down, left, right movements
        int[] dirs = {0, 1, 0, -1, 0};
        
        // Initialize the result matrix with a large value
        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);  // Start with a large number
        }
        
        // Queue for BFS
        Queue<int[]> queue = new LinkedList<>();
        
        // Enqueue all cells with 1 and set their distance to 0 in the result matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    queue.offer(new int[] {i, j});
                    dist[i][j] = 0; // Distance to itself is 0
                }
            }
        }
        
        // Perform BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            
            // Check all 4 directions
            for (int i = 0; i < 4; i++) {
                int nx = x + dirs[i];
                int ny = y + dirs[i + 1];
                
                // If the neighbor is within bounds and we can relax the distance
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && dist[nx][ny] == Integer.MAX_VALUE) {
                    dist[nx][ny] = dist[x][y] + 1;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
        
        return dist;
    }

    public static void main(String[] args) {
        // Creating an object of Nearest_Cell_having_1_Matrix
        Nearest_Cell_having_1_Matrix obj = new Nearest_Cell_having_1_Matrix();
        
        // Example matrix 1
        int[][] mat1 = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        int[][] result1 = obj.updateMatrix(mat1);
        System.out.println("Result for mat1:");
        for (int[] row : result1) {
            System.out.println(Arrays.toString(row));
        }
        
        // Example matrix 2
        int[][] mat2 = {
            {0, 0, 0},
            {0, 1, 0},
            {1, 1, 1}
        };
        int[][] result2 = obj.updateMatrix(mat2);
        System.out.println("Result for mat2:");
        for (int[] row : result2) {
            System.out.println(Arrays.toString(row));
        }
    }
}
